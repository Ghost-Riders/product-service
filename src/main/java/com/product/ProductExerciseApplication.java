package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ProductExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductExerciseApplication.class, args);
	}

}
