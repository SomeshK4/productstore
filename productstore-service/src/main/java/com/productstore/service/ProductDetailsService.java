package com.productstore.service;

import java.util.List;

import com.productstore.domain.ProductDetails;

public interface ProductDetailsService {
	
	List<ProductDetails> readProductDetails(String type, String city, Double minPrice, Double maxPrice,
			String property, String colorProperty, Integer gbLimitMin, Integer gbLimitMax);

}
