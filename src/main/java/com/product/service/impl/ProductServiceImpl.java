package com.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Page<Product> ListOfProductsPropertyOrderByFromSize(String property, String orderBy, int from, int size) {
		// property: column anme
		// orderBy: ASC or DESC
		// limit: from & size
		Direction order = null;
		if (orderBy.equalsIgnoreCase("DESC")) {
			order = Direction.DESC;
		} else {
			order = Direction.ASC;
		}
		Pageable productSort = PageRequest.of(from, size, order, property);
		return productRepository.findAll(productSort);
	}

}
