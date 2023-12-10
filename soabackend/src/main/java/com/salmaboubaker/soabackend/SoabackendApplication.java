package com.salmaboubaker.soabackend;

import com.salmaboubaker.soabackend.entities.Paiement;
import com.salmaboubaker.soabackend.services.PaiementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SoabackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SoabackendApplication.class, args);

}}
