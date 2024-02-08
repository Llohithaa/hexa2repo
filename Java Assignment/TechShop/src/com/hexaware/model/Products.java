package com.hexaware.model;

public class Products {
	private int productId;
	private String productName;
	private String description;
	private double price;
	
	//Default constructor
	public Products(){
		
	}
	
	//Parameterized constructor
	public Products(int productId, String productName, String description, double price){
		super();
		this.productId=productId;
		this.productName=productName;
		this.description=description;
		this.price=price;
	}
	
	//getters and setters
	public int getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setProductId(int productId) {
		this.productId=productId;
	}
	
	public void setProductName(String productName) {
		this.productName=productName;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public void getProductDetails() {
		System.out.println("ProductId:" + productId + "\nProductName:" + productName + "\nDescription:" + description + "\nPrice:" + price);
	}
	
	public void updateProductInfo(double price, String description) {
		this.price=price;
		this.description=description;
	}
	
	public boolean isProductInStock() {
		return true;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	
}
