package com.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.product.model.Product;

@SpringBootTest
@Transactional
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void listOfProducts() {
		String property = "id";
		String orderBy = "asc";
		int from = 0;
		int size = 5;
		List<Product> list = null;
		Exception exception = null;
		try {
			Page<Product> pageProduct = productService.ListOfProductsPropertyOrderByFromSize(property, orderBy, from,
					size);
			list = pageProduct.getContent();
		} catch (Exception e) {
			exception = e;
		}
		assertNull(exception, "Failed -expected not null");
		assertEquals(0, list.size(), "Failed - expetecd size 0");
	}
}
