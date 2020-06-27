package com.productstore.dao.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.productstore.dao.ProductDetailsRepository;
import com.productstore.domain.configuration.ProductStoreDomainConfiguration;

@Configuration
@EnableJpaRepositories(basePackageClasses = ProductDetailsRepository.class)
@EnableTransactionManagement
@Import(ProductStoreDomainConfiguration.class)
public interface ProductStoreDaoConfiguration {

}
