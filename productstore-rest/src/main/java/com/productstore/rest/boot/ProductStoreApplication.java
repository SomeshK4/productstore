package com.productstore.rest.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.productstore.service.configuration.ProductStoreServiceConfiguration;

@SpringBootApplication(scanBasePackages = { "com.productstore.rest.controller" })
@Import(ProductStoreServiceConfiguration.class)
public class ProductStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductStoreApplication.class, args);
	}

}
