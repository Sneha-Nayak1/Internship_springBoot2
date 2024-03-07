package com.example.demo.controller;

//import java.util.List;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	public ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> createproduct(@RequestBody ProductDto productDto){
		
		return new ResponseEntity<>(productService.createproduct(productDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>>  getAllProducts(){
		List<ProductDto> product=productService.getAllProducts();
		return ResponseEntity.ok(product);
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct( @PathVariable("id") long id, @RequestBody ProductDto productDto){
		return new ResponseEntity<>(productService.updateProduct( id,productDto),HttpStatus.OK);
	}
	
	

//	@PostMapping("/{id}")
//	public ResponseEntity<Map<String, String>> updateProduct(@PathVariable("id") long id, @RequestBody ProductDto productDto) {
//	    try {
//	        ProductDto updatedProduct = productService.updateProduct(id, productDto);
//	        if (updatedProduct != null) {
//	            Map<String, String> response = new HashMap<>();
//	            response.put("message", "Product Updated Successfully");
//	            return new ResponseEntity<>(response, HttpStatus.OK);
//	        } else {
//	            Map<String, String> errorResponse = new HashMap<>();
//	            errorResponse.put("error", "Product with ID " + id + " not found");
//	            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//	        }
//	    } catch (Exception e) {
//	        Map<String, String> errorResponse = new HashMap<>();
//	        errorResponse.put("error", "Error updating product: " + e.getMessage());
//	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	}

	
	@GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteById(@PathVariable("id") long id) {
        try {
            productService.deleteProduct(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Account Deleted Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error deleting entity: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
