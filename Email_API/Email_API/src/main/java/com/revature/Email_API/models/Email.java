package com.revature.Email_API.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "email")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emailId;

    @Column(name = "Date")
    private String date;

    @Column(name = "Recipient")
    private String recipient;

    @Column(name = "Sender")
    private String sender;

    @Column(name = "Subject")
    private String subject;

    @Column(name = "Content")
    private String content;
}
