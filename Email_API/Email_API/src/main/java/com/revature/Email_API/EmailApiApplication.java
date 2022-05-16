package com.revature.Email_API;

import com.revature.Email_API.models.User;
import com.revature.Email_API.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailApiApplication {

	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(EmailApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> { for (User u: userRepo.findByUserId(1)) {System.out.println(u);}

};}}
