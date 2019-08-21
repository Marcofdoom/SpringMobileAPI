package com.bae.mobileapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.bae.mobileapi.repository.AssociateRepository;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties
@SpringBootApplication
public class SpringMobileApiApplication {

	@Autowired
	public static AssociateRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMobileApiApplication.class, args);
		repo.findAssociateReceivers();
	}

}