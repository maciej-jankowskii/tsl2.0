package com.example.tsl.controller;

import com.example.tsl.model.invoices.carrierFv.InvoiceFromCarrier;
import com.example.tsl.model.invoices.customerFv.InvoiceForCustomer;
import com.example.tsl.model.invoices.service.InvoiceForCustomerService;
import com.example.tsl.model.invoices.service.InvoiceFromCarrierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceFromCarrierService invoiceFromCarrierService;
    private final InvoiceForCustomerService invoiceForCustomerService;

    public InvoiceController(InvoiceFromCarrierService invoiceFromCarrierService, InvoiceForCustomerService invoiceForCustomerService) {
        this.invoiceFromCarrierService = invoiceFromCarrierService;
        this.invoiceForCustomerService = invoiceForCustomerService;
    }

    @GetMapping("/carrier")
    public String carrierInvoicesForm(Model model) {
        List<InvoiceFromCarrier> allInvoices = invoiceFromCarrierService.findAll();
        model.addAttribute("allInvoices", allInvoices);
        return "invoices/carrier-invoices";
    }

    @GetMapping("/customer")
    public String customerInvoicesFrom(Model model) {
        List<InvoiceForCustomer> allInvoices = invoiceForCustomerService.findAll();
        model.addAttribute("allInvoices", allInvoices);
        return "invoices/customer-invoices";
    }

}
