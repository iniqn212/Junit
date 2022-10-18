package com.qa.jtest.repository;

import java.util.Arrays;
import java.util.List;

import com.qa.jtest.exception.InvalidInputException;
import com.qa.jtest.exception.ProductNotFoundException;
import com.qa.jtest.model.Product;

public class ProductRepository {

	List<Product> productList;

	public ProductRepository() {

		this.productList = Arrays.asList(new Product(1, "Orange", 300), new Product(2, "Watermelon", 150),
				new Product(3, "Bannana", 500));

	}

	public Product getProductById(int id) throws ProductNotFoundException, InvalidInputException {
		boolean valid = validId(id);
		if (!valid)
			throw new InvalidInputException("Id should be positive");
		return this.productList.stream().filter(product -> product.getId() == id).findFirst()
				.orElseThrow(() -> new ProductNotFoundException("No product with this Id"));

	}

	private boolean validId(int id) {
		return id > 0 ? true : false;

	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}



}
