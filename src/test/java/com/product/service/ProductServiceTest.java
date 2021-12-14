package com.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.product.ProductExerciseApplication;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@SpringBootTest(classes = ProductExerciseApplication.class)
@Transactional(rollbackOn = ProductServiceTest.class)
public class ProductServiceTest extends Exception {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@BeforeEach
	public void setUp() throws Exception {
		String productList[] = { "Apple", "Mango", "SugarKane", "PineApple", "Papita", "Grepes" };
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product productTest = new Product();
			productTest.setAmount((int) (Math.random() * 10000));
			productTest.setProductName(productList[(int) (Math.random() * productList.length)]);
			products.add(productTest);
		}
		productRepository.saveAllAndFlush(products);
	}

	@AfterEach
	public void tearDown() throws Exception {
//		productRepository.deleteAllInBatch();
	}

	@Test
	public void listOfProducts() throws Exception {
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
		assertEquals(size, list.size(), "Failed - expetecd size : " + size);
	}
}
