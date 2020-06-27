package com.productstore.service.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.productstore.dao.configuration.ProductStoreDaoConfiguration;

@Configuration
@ComponentScan(basePackages = "com.productstore.service")
@Import(ProductStoreDaoConfiguration.class)
public interface ProductStoreServiceConfiguration {

}
