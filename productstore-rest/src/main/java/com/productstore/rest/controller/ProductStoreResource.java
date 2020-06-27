package com.productstore.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productstore.domain.ProductDetails;
import com.productstore.rest.dto.ProductDTO;
import com.productstore.rest.dto.ProductDetailsDTO;
import com.productstore.rest.mapper.ProductDetailsMapper;
import com.productstore.service.ProductDetailsService;

@RestController
public class ProductStoreResource {

	@Autowired
	private ProductDetailsService productDetailsService;

	@GetMapping("/product")
	public ProductDetailsDTO getProductDetails(@RequestParam(required = false) String type,
			@RequestParam(required = false) String city,
			@RequestParam(name = "min_price", required = false) Double minPrice,
			@RequestParam(name = "max_price", required = false) Double maxPrice,
			@RequestParam(required = false) String property,
			@RequestParam(name = "property:color", required = false) String colorProperty,
			@RequestParam(name = "property:gb_limit_min", required = false) Integer gbLimitMin,
			@RequestParam(name = "property:gb_limit_max", required = false) Integer gbLimitMax) {

		List<ProductDetails> productDetails = productDetailsService.readProductDetails(type, city, minPrice, maxPrice,
				property, colorProperty, gbLimitMin, gbLimitMax);
		List<ProductDTO> productList = productDetails.stream()
		   .map(productDetail -> {
			return ProductDetailsMapper.MAPPER.toProductDTO(productDetail);
		}).collect(Collectors.toList());
		return ProductDetailsDTO.builder().data(productList).build();
	}

}
