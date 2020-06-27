package com.productstore.rest.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetailsDTO {
	
	private List<ProductDTO> data;

}
