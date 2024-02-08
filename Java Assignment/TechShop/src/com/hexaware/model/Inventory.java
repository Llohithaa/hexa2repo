package com.hexaware.model;

public class Inventory {
	private int inventoryId;
	private int productId;
	private int quantityInStock;
	private String lastStockUpdate;
	
	//Default constructor{
	public Inventory() {
		
	}
	
	//Parameterized constructor
	public Inventory(int inventoryId, int productId, int quantityInStock, String lastStockUpdate){
		super();
	    this.inventoryId=inventoryId;
		this.productId=productId;
		this.quantityInStock=quantityInStock;
		this.lastStockUpdate=lastStockUpdate;
		 }
	
	//Getters and setters
	public int getInventoryId() {
		return inventoryId;
	}
	
	public String getLastStockUpdate() {
		return lastStockUpdate;
	}
	
	public void setInventoryId(int inventoryId) {
		this.inventoryId=inventoryId;
	}
	
    public void setProductId(int productId) {
    	this.productId=productId;
	}

    public void setQuantityInStock(int quantityInStock) {
    	this.quantityInStock=quantityInStock;
	}
    
    public void setLastStockUpdate(String lastStockUpdate) {
    	this.lastStockUpdate=lastStockUpdate;
	}
	
    public int getProductId() {
		return productId;
	}
    
	public int getQuantityInStock() {
		return quantityInStock;
	}
    
	public void addToInventory(int quantity) {
		
	}
	
	public void removeFromInventory(int quantity) {
		
	}
	
	public void updateStockQuantity(int newQuantity) {
		
	}
	
	public void isProductAvailable(int quantityToCheck) {
		
	}
	
	public int getInventoryValue() {
		return 0;
	}
	
	public void listLowStockProducts(int threshold) {
		
	}
	
	public void listOutOfStockProducts() {
		
	}
	
	public void listAllProducts() {
		
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", quantityInStock="
				+ quantityInStock + ", lastStockUpdate=" + lastStockUpdate + "]";
	}
	
	
}
