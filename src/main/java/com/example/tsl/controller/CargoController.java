package com.example.tsl.controller;

import com.example.tsl.model.cargos.Cargo;
import com.example.tsl.model.cargos.CargoDTO;
import com.example.tsl.model.cargos.CargoService;
import com.example.tsl.model.contractors.customer.Customer;
import com.example.tsl.model.contractors.service.ContractorContactPersonService;
import com.example.tsl.model.contractors.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargoController {
    private final CargoService cargoService;
    private final CustomerService customerService;

    public CargoController(CargoService cargoService, CustomerService customerService) {
        this.cargoService = cargoService;
        this.customerService = customerService;
    }


    @GetMapping()
    public String cargosForm(Model model) {
        List<Cargo> allCargos = cargoService.findAll();
        model.addAttribute("allCargos", allCargos);
        return "spedition/cargos";
    }

    @GetMapping("/create-cargo")
    public String createCargoForm(Model model) {
        List<Customer> allCustomers = customerService.findAll();
        model.addAttribute("allCustomers", allCustomers);
        return "spedition/add-cargo";
    }

    @PostMapping("/create-cargo")
    public String addCargo(@ModelAttribute CargoDTO cargoDTO) {
        cargoService.addCargo(cargoDTO);
        return "redirect:/cargos";
    }
}
