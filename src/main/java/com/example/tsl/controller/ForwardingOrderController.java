package com.example.tsl.controller;

import com.example.tsl.exceptions.EmployeeNotFoundException;
import com.example.tsl.model.cargos.Cargo;
import com.example.tsl.model.cargos.CargoService;
import com.example.tsl.model.contractors.carrier.Carrier;
import com.example.tsl.model.contractors.service.CarrierService;
import com.example.tsl.model.employees.baseEntity.Employee;
import com.example.tsl.model.employees.officeWorkers.Forwarder;
import com.example.tsl.model.employees.service.EmployeeService;
import com.example.tsl.model.employees.service.ForwarderService;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrder;
import com.example.tsl.model.orders.forwarderOrder.ForwardingOrderDTO;
import com.example.tsl.model.orders.service.ForwardingOrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class ForwardingOrderController {

    private final CarrierService carrierService;
    private final CargoService cargoService;
    private final ForwardingOrderService forwardingOrderService;
    private final EmployeeService employeeService;

    public ForwardingOrderController(CarrierService carrierService, CargoService cargoService,
                                     ForwardingOrderService forwardingOrderService, EmployeeService employeeService) {
        this.carrierService = carrierService;
        this.cargoService = cargoService;
        this.forwardingOrderService = forwardingOrderService;
        this.employeeService = employeeService;
    }
    @GetMapping("/forwarding-orders")
    public String forwardingOrderForm(Model model, Authentication authentication){
        Employee employee = employeeService.findByEmail(authentication.getName()).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        List<ForwardingOrder> allOrdersByForwarder = forwardingOrderService.findForwardingOrderByEmployee(employee);
        model.addAttribute("allOrdersByForwarder", allOrdersByForwarder);

        return "spedition/forwarding-orders";
    }

    @GetMapping("/create-forwarding-order")
    public String createOrderForm(Model model){
        List<Carrier> allCarriers = carrierService.findAll();
        List<Cargo> allCargos = cargoService.findAll();
        model.addAttribute("allCarriers", allCarriers);
        model.addAttribute("allCargos", allCargos);
        return "spedition/create-order";
    }

    @PostMapping("/create-forwarding-order")
    public String createOrder(@ModelAttribute ForwardingOrderDTO forwardingOrderDTO, Authentication authentication){
        String username = authentication.getName();
        forwardingOrderService.createOrder(forwardingOrderDTO, username);
        return "redirect:/orders/forwarding-orders";
    }
}
