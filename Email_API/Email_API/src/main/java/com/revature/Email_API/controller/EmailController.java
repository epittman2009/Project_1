package com.revature.Email_API.controller;


import com.revature.Email_API.models.Email;
import com.revature.Email_API.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity getAllEmails() {
        return emailService.getEmails();
    }

    @PostMapping
    public ResponseEntity sendEmail(@RequestBody Email email) throws URISyntaxException {
        return emailService.sendEmail(email);
    }

    @GetMapping("{id}")
    public ResponseEntity getEmailById(@PathVariable int id) {
        return emailService.getEmailById(id);
    }
}
