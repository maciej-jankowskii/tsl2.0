package com.example.tsl.model.cargos;

import com.example.tsl.exceptions.CustomerNotFoundException;
import com.example.tsl.exceptions.WrongLoadigDateException;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.repository.CustomerRepository;
import com.example.tsl.model.contractors.service.CustomerService;
import com.example.tsl.model.invoices.service.VatCalculatorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final VatCalculatorService vatCalculatorService;

    public CargoService(CargoRepository cargoRepository, CargoMapper cargoMapper, CustomerService customerService,
                        CustomerRepository customerRepository, VatCalculatorService vatCalculatorService) {
        this.cargoRepository = cargoRepository;
        this.cargoMapper = cargoMapper;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.vatCalculatorService = vatCalculatorService;
    }

    public List<Cargo> findAll(){
        return cargoRepository.findAll();
    }

    public Optional<Cargo> findById(Long id){
        return cargoRepository.findById(id);
    }
    @Transactional
    public CargoDTO addCargo(CargoDTO cargoDTO){
        Customer customer = extractCustomerFromCargoDTO(cargoDTO);
        Cargo cargo = cargoMapper.map(cargoDTO);

        addAdditionalDataForCargo(cargo, customer);
        checkingLoadingData(cargo);
        changeCustomerBalance(customer, cargo);

        customerRepository.save(customer);
        Cargo saved = cargoRepository.save(cargo);
        return cargoMapper.map(saved);
    }

    private void changeCustomerBalance(Customer customer, Cargo cargo) {
        BigDecimal price = checkingBruttoPrice(customer, cargo);
        BigDecimal balance = customer.getBalance();
        customer.setBalance(balance.add(price));
    }

    private BigDecimal checkingBruttoPrice(Customer customer, Cargo cargo) {
        String vatNumber = customer.getVatNumber();
        BigDecimal cargoPrice = cargo.getPrice();
        return vatCalculatorService.calculateBrutto(cargoPrice, vatNumber);
    }

    private Customer extractCustomerFromCargoDTO(CargoDTO cargoDTO) {
        Long customerId = cargoDTO.getCustomerDTO().getId();
        Customer customer = customerService.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return customer;
    }

    private static void checkingLoadingData(Cargo cargo) {
        LocalDate loadingDate = cargo.getLoadingDate();
        LocalDate unloadingDate = cargo.getUnloadingDate();
        if (unloadingDate != null && unloadingDate.isBefore(loadingDate)){
            throw new WrongLoadigDateException("The loading date cannot be later than the unloading date");
        }
    }

    private static void addAdditionalDataForCargo(Cargo cargo, Customer customer) {
        cargo.setCustomer(customer);
        cargo.setDateAdded(LocalDate.now());
        cargo.setAssignedToOrder(false);
        cargo.setInvoiced(false);
        customer.getCargos().add(cargo);
    }
}
