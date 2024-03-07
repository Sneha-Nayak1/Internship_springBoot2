package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;

import com.example.demo.entity.Product;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	@Override
	public ProductDto createproduct(ProductDto productDto) {
		Product product=ProductMapper.mapToProduct(productDto);
		Product saved=productRepository.save(product);
		return ProductMapper.mapToProductDto(saved);
		
	}


	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products=productRepository.findAll();
		return products.stream().map((product)->ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
			}


	@Override
	public ProductDto updateProduct(long id, ProductDto productDto) {
		Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
		product.setProductName(productDto.getProductName());
		product.setCategory(productDto.getCategory());
		product.setProductName(productDto.getProductName());
		product.setFreshness(productDto.getFreshness());
		product.setPrice(productDto.getPrice());
		product.setComment(productDto.getComment());
		
		
		Product saved=productRepository.save(product);
		return ProductMapper.mapToProductDto(saved);
		
	}


	@Override
	public void deleteProduct(long id) {
		 Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		productRepository.deleteById(id);
		
	}

}
