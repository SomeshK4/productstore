package com.productstore.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
	
	private String type;
	private String properties;
	private Double price;
	private String store_address;

}
