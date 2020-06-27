package com.productstore.domain.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import com.productstore.domain.ProductDetails;

@Configuration
@EntityScan(basePackageClasses = ProductDetails.class)
public interface ProductStoreDomainConfiguration {

}
