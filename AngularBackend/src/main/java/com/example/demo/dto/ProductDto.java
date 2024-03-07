package com.example.demo.dto;

public class ProductDto {
	
	private long id;
	private String productName;
	private String category;
	private String freshness;
	private double price;
	private String comment;
	private String date;
	
	
	public ProductDto(long id, String productName, String category, String freshness, double price, String comment,
			String date) {
		super();
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.freshness = freshness;
		this.price = price;
		this.comment = comment;
		this.date = date;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public ProductDto() {
		
	}
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFreshness() {
		return freshness;
	}
	public void setFreshness(String freshness) {
		this.freshness = freshness;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
