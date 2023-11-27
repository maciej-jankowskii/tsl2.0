package com.example.tsl.model.contact;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactFormService {
    private final ContactFormRepository contactFormRepository;
    private final EmailService emailService;

    public ContactFormService(ContactFormRepository contactFormRepository, EmailService emailService) {
        this.contactFormRepository = contactFormRepository;
        this.emailService = emailService;
    }
    @Transactional
    public void processContactForm(ContactForm contactForm){
        contactFormRepository.save(contactForm);
        emailService.sendEmail("test@tsl.com", contactForm.getSubject(), contactForm.getMessage());
    }
}
