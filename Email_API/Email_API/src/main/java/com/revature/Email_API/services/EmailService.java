package com.revature.Email_API.services;

import com.revature.Email_API.models.Email;
import com.revature.Email_API.repos.EmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class EmailService {

    @Autowired
    private EmailRepo emailRepo;

    public ResponseEntity getEmails() {
        return ResponseEntity.ok(emailRepo.findAll());
    }

    public ResponseEntity sendEmail(Email email) throws URISyntaxException {
        emailRepo.save(email);
        return ResponseEntity.created(new URI("http://localhost/emails/" + email.getEmailId())).build();
    }
    public ResponseEntity getEmailById(int id) {
        Optional<Email> email = emailRepo.findById(id);
        if (email.isPresent()) {
            return ResponseEntity.ok(email);
        } return ResponseEntity.notFound().build();
    }
}
