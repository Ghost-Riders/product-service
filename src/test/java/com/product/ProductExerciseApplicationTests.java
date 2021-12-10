package com.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = ProductExerciseApplication.class)
@Transactional
class ProductExerciseApplicationTests {

	@Test
	void contextLoads() {
	}

}
