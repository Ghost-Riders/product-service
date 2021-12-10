package com.product.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/v1/transactions")
	private List<Product> listOfProducts(@RequestParam("orderBy") String property,
			@RequestParam("direction") String orderBy, @RequestParam("from") Integer from,
			@RequestParam("size") Integer size) {
		Page<Product> productPage = productService.ListOfProductsPropertyOrderByFromSize(property, orderBy, from, size);
		return productPage.getContent();
	}
}
