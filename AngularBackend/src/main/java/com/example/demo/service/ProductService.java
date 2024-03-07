package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;



public interface ProductService {
	ProductDto createproduct(ProductDto productDto);
	List<ProductDto> getAllProducts();
	ProductDto updateProduct( long id, ProductDto productDto);
	void deleteProduct(long id);
}
