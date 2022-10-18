package com.qa.jtest.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import com.qa.jtest.exception.ProductNotFoundException;
import com.qa.jtest.exception.InvalidInputException;
import com.qa.jtest.model.Product;

public class ProductRepositoryTest {

	Scanner scanner = new Scanner(System.in);

	ProductRepository ProductRepository;

	// Write test cases

	// @BeforeAll -> static method
	// @AfterAll -> static method
	// @BeforeEach
	// @AfterEach
	// @Test

	/*
	 * @BeforeAll public static void setUp() { // database connection //
	 * configuration // Initialisation of data
	 * System.out.println("@BeforeAll -> setUp "); }
	 * 
	 * @AfterAll public static void cleanUp() { // making the resources null
	 * System.out.println("@AfterAll --> cleanUp"); }
	 */

	@BeforeEach
	public void setUp() {
		this.ProductRepository = new ProductRepository();
	}

	@AfterEach
	public void cleanUp() {
		this.ProductRepository = null;
	}

	@Test
	@DisplayName("getProductById(id) -> Throws ProductNotFoundException")
	public void givenNonExistingId_whenGetProductById_thenThrowProductNotFoundException() {

		assertThrows(ProductNotFoundException.class, () -> this.ProductRepository.getProductById(1));
	}

	@Test
	@DisplayName("getProductById(invalid) -> Throws InvalidInputException")
	public void givenInvalidInputAsId_whenGetProductById_thenThrowInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> this.ProductRepository.getProductById(-100));
	}

	@Test
	@DisplayName("getProductById(id) -> Return Product")
	public void givenExistingId_whenGetProductById_thenReturnProduct()
			throws ProductNotFoundException, InvalidInputException {
		// testing the code
		// expected vs actual
		Product Product = this.ProductRepository.getProductById(1);
		assertNotNull(ProductRepository);
		assertEquals("Orange", Product.getName());
		assertEquals(300, Product.getQuantity());
	}

}
