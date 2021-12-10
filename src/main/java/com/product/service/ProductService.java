package com.product.service;

import org.springframework.data.domain.Page;

import com.product.model.Product;

public interface ProductService {

	Page<Product> ListOfProductsPropertyOrderByFromSize(String property, String orderBy, int from, int size);
}
