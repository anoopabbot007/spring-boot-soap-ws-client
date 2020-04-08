package com.abbot.spring.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbot.spring.soap.api.client.SoapClient;
import com.abbot.spring.soap.api.loaneligibility.Acknowledgement;
import com.abbot.spring.soap.api.loaneligibility.CustomerRequest;

@SpringBootApplication
@RestController
public class SpringBootSopaWsClientApplication {
	
	@Autowired
	private SoapClient clinet;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		return clinet.getLoanStatus(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSopaWsClientApplication.class, args);
	}

}
