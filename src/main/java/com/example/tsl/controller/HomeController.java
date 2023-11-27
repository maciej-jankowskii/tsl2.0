package com.example.tsl.controller;

import com.example.tsl.model.contact.ContactForm;
import com.example.tsl.model.contact.ContactFormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final ContactFormService contactFormService;

    public HomeController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @GetMapping("/")
    public String home() {
        return "home/index";
    }

    @GetMapping("/login-form")
    public String login() {
        return "home/login-form";
    }

    @GetMapping("/main-page")
    public String mainPageForm() {
        return "home/main-page";
    }

    @GetMapping("/main-info")
    public String mainInfoForm(){
        return "home/main-info";
    }

    @GetMapping("/demo")
    public String demoInfoFrom(){
        return "home/demo";
    }

    @GetMapping("/contact")
    public String contactForm(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "home/contact-form";
    }

    @PostMapping("/submit-contact")
    public String submitContactForm(@ModelAttribute("contactForm") ContactForm contactForm){
        contactFormService.processContactForm(contactForm);
        return "redirect:/contact-confirm";
    }

    @GetMapping("/contact-confirm")
    public String contactConfirmation(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "home/contact-confirmation";
    }
}
