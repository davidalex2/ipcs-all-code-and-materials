package com.ipcs.mailsender.controller;

import com.ipcs.mailsender.model.EmailEntity;
import com.ipcs.mailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(EmailEntity emailEntity) {
        emailService.sendEmail(emailEntity);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);

    }
}