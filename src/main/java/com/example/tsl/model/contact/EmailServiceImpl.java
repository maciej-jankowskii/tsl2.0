package com.example.tsl.model.contact;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String content) {
        System.out.println("Symulacja wysłania e-maila: ");
        System.out.println("Do: " + to);
        System.out.println("Temat: " + subject);
        System.out.println("Treść: " + content);


    }
}
