package com.ipcs.mailsender.service;

import com.ipcs.mailsender.model.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(EmailEntity emailEntity) {
        if (emailEntity == null || emailEntity.getTo().trim().isEmpty()) {
            throw new IllegalArgumentException("EmailEntity or 'to' property is null or empty");
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("ipcstech.it@gmail.com");
        mailMessage.setSubject(emailEntity.getSubject());
        mailMessage.setText(emailEntity.getBody());
        javaMailSender.send(mailMessage);
    }
}