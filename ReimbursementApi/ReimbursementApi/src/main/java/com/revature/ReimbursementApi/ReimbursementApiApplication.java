package com.revature.ReimbursementApi;

import com.revature.ReimbursementApi.Models.Employee;
import com.revature.ReimbursementApi.Repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReimbursementApiApplication {

	@Autowired
	EmployeeRepo employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(ReimbursementApiApplication.class, args);
	}

}
