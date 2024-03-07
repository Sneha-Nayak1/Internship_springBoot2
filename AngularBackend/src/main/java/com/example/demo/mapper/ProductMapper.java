package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

public class ProductMapper {
	public static Product mapToProduct(ProductDto productDto) {
		Product product= new Product(productDto.getId(),
									productDto.getProductName(),
									productDto.getCategory(),
									productDto.getFreshness(),
									productDto.getPrice(),
									productDto.getComment(),
									productDto.getDate()
									);
		return product;
	}
	
	
	public static ProductDto mapToProductDto(Product product) {
		ProductDto productDto = new ProductDto(
								product.getId(),
									product.getProductName(),
									product.getCategory(),
									product.getFreshness(),
									product.getPrice(),
									product.getComment(),
									product.getDate());
		return productDto;
	}
}
