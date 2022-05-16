package com.revature.Email_API;

import com.revature.Email_API.DTOs.EmailDTO;
import com.revature.Email_API.models.Email;
import com.revature.Email_API.repos.EmailRepo;
import com.revature.Email_API.repos.UserRepo;
import com.revature.Email_API.services.EmailService;
import com.revature.Email_API.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmailServiceTest {

    private EmailDTO emailDTO = EmailDTO.builder()
            .date("03/06/2022")
            .sender("IronMan@avengers.com")
            .recipient("HulkNotHogan@avengers.com")
            .subject("Your request has been received")
            .content("We received your new reimbursement request. CLick here to review your request")
            .build();

    private Email email;

    @Test
    void shouldCreateEmail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyy");
        LocalDateTime now = LocalDateTime.now();
        String date = formatter.format(now);

        String subject = emailDTO.getSubject();
        String content = emailDTO.getContent();

        String recipient = emailDTO.getRecipient();
        String sender = emailDTO.getSender();

        email = new Email();
        email.setDate(date);
        email.setRecipient(recipient);
        email.setSender(sender);
        email.setSubject(subject);
        email.setContent(content);

        assertEquals("HulkNotHogan@avengers.com", email.getRecipient());
    }



}
