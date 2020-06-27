package com.productstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="product_type")
	private String productType;
	
	@Column(name="price")
	private double price;
	
	
	@Column(name="store_address")
	private String storeAddress;
	
	@Column(name="product_property")
	private String productProperty;

}
