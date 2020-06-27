package com.productstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.productstore.domain.ProductDetails;

@Repository
@Transactional
public interface ProductDetailsRepository
		extends JpaRepository<ProductDetails, Integer>, JpaSpecificationExecutor<ProductDetails> {

	
	public default List<ProductDetails> findByCriteria(String type, String city, Double minPrice, Double maxPrice,
			String property, String colorProperty, Integer gbLimitMin, Integer gbLimitMax) {
		return findAll(new Specification<ProductDetails>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1407566980408997466L;

			@Override
			public Predicate toPredicate(Root<ProductDetails> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (null != type) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("productType"), type)));
				}
				if (null != city) {
					predicates
							.add(criteriaBuilder.and(criteriaBuilder.like(root.get("storeAddress"), "%" + city + "%")));
				}

				if (null != minPrice) {
					predicates.add(criteriaBuilder.ge(root.get("price"), minPrice));
				}

				if (null != maxPrice) {
					predicates.add(criteriaBuilder.le(root.get("price"), maxPrice));
				}

				if (null != property) {
					predicates.add(
							criteriaBuilder.and(criteriaBuilder.like(root.get("productProperty"), property + ":%")));
				}

				if (null != colorProperty) {
					predicates.add(
							criteriaBuilder.and(criteriaBuilder.like(root.get("productProperty"), "%:" + colorProperty)));
				}

				if(null != gbLimitMin || null != gbLimitMax) {
					predicates.add(
							criteriaBuilder.and(criteriaBuilder.like(root.get("productProperty"), "gb_limit:%")));
				}
				
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}

}
