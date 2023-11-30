package com.example.tsl.controller;

import com.example.tsl.model.address.AddressDTO;
import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.contractors.carrier.CarrierDTO;
import com.example.tsl.model.contractors.contactPerson.ContractorContactPersonDTO;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.customer.CustomerDTO;
import com.example.tsl.model.contractors.service.CarrierService;
import com.example.tsl.model.contractors.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contractors")
public class ContractorController {
    private final CustomerService customerService;
    private final CarrierService carrierService;

    public ContractorController(CustomerService customerService, CarrierService carrierService) {
        this.customerService = customerService;
        this.carrierService = carrierService;
    }

    @GetMapping("/customers")
    public String customersForm(Model model) {
        List<Customer> allCustomers = customerService.findAll();
        model.addAttribute("allCustomers", allCustomers);
        return "spedition/customers";
    }

    @GetMapping("/carriers")
    public String carrierForm(Model model) {
        List<Carrier> allCarriers = carrierService.findAll();
        model.addAttribute("allCarriers", allCarriers);
        return "spedition/carriers";
    }

    @GetMapping("/create-customer")
    public String createCustomerForm() {
        return "spedition/add-customer";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute CustomerDTO customerDTO,
                                 @ModelAttribute AddressDTO addressDTO,
                                 @ModelAttribute ContractorContactPersonDTO contractorContactPersonDTO) {
        customerService.addCustomer(customerDTO, addressDTO, contractorContactPersonDTO);
        return "redirect:/contractors/customers";
    }

    @GetMapping("/create-carrier")
    public String createCarrierForm() {
        return "spedition/add-carrier";
    }

    @PostMapping("/create-carrier")
    public String createCarrier(@ModelAttribute CarrierDTO carrierDTO,
                                @ModelAttribute AddressDTO addressDTO,
                                @ModelAttribute ContractorContactPersonDTO contractorContactPersonDTO) {
        carrierService.addCarrier(carrierDTO, addressDTO, contractorContactPersonDTO);
        return "redirect:/contractors/carriers";
    }
}
