package com.example.tsl.model.contact;

public interface EmailService {
    void sendEmail(String to, String subject, String content);

    //W przyszłości można użyć np JavaMailSender i sprobować zasymulować faktyczne wysłanie wiadomości e-mail przez formularz
}
