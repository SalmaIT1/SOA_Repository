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

		// Retrieve the PaiementService bean from the context
		PaiementService paiementService = context.getBean(PaiementService.class);

		// Retrieve payment with ID = 1
		Long paymentId = 1L;
		Paiement retrievedPayment = paiementService.getPaiementById(paymentId).orElse(null);

		// Print the date of the retrieved payment
		if (retrievedPayment != null) {
			System.out.println("Date of Payment with ID 1: " + retrievedPayment.getDatePaiement());
		} else {
			System.out.println("Payment with ID " + paymentId + " not found.");
		}
	}
}
