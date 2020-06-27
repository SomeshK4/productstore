package com.productstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productstore.dao.ProductDetailsRepository;
import com.productstore.domain.ProductDetails;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	public List<ProductDetails> readProductDetails(String type, String city, Double minPrice, Double maxPrice,
			String property, String colorProperty, Integer gbLimitMin, Integer gbLimitMax) {
		List<ProductDetails> prodDetailsLst = productDetailsRepository.findByCriteria(type, city, minPrice, maxPrice,
				property, colorProperty, gbLimitMin, gbLimitMax);
        if(null != gbLimitMin && null != gbLimitMax) {
        	prodDetailsLst = prodDetailsLst.stream().filter(prodDetails -> {
        		return (extractGbLimitValue(prodDetails) >= gbLimitMin && extractGbLimitValue(prodDetails) <= gbLimitMax);
        	}).collect(Collectors.toList());
        }else if(null != gbLimitMin && null == gbLimitMax) {
        	prodDetailsLst = prodDetailsLst.stream().filter(prodDetails -> {
        		return extractGbLimitValue(prodDetails) >= gbLimitMin;
        	}).collect(Collectors.toList());
        }else if(null != gbLimitMax && null == gbLimitMin) {
        	prodDetailsLst = prodDetailsLst.stream().filter(prodDetails -> {
        		return extractGbLimitValue(prodDetails) <= gbLimitMax;
        	}).collect(Collectors.toList());
        }
        
		return prodDetailsLst;

	}
	
	private Integer extractGbLimitValue(ProductDetails productDetails) {
		String[] strArr = productDetails.getProductProperty().split(":");
		Integer value = Integer.parseInt(strArr[1]);
		return value;
	}

}
