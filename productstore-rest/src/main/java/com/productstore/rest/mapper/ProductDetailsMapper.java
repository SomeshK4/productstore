package com.productstore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.productstore.domain.ProductDetails;
import com.productstore.rest.dto.ProductDTO;

@Mapper
public interface ProductDetailsMapper {
	
	ProductDetailsMapper MAPPER = Mappers.getMapper(ProductDetailsMapper.class);
	
	@Mapping(source = "productType", target = "type")
	@Mapping(source = "productProperty", target = "properties")
	@Mapping(source = "storeAddress", target = "store_address")
	ProductDTO toProductDTO(ProductDetails productDetails);

}
