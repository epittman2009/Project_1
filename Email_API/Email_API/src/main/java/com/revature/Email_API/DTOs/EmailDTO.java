package com.revature.Email_API.DTOs;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDTO {

    private String date;
    private String recipient;
    private String sender;
    private String subject;
    private String content;
}
