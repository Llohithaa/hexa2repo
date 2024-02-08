package com.hexaware.controller;

import com.hexaware.dao.InventoryImplementation;
import com.hexaware.model.Inventory;
import java.util.Scanner;

public class InventoryController {
	Scanner sc = new Scanner(System.in);
	InventoryImplementation impl=new InventoryImplementation();
	Inventory inventory;
	public void displayAddInventory() {
		System.out.println("Enter InventoryId");
		int inventoryId=sc.nextInt();
		System.out.println("Enter productId");
		int productId=sc.nextInt();
		System.out.println("Enter quantityInStock");
		int quantityInStock=sc.nextInt();
		System.out.println("Enter lastStockUpdate");
		String lastStockUpdate=sc.next();
		inventory=new Inventory(inventoryId, productId, quantityInStock, lastStockUpdate);
		impl.getInventoryProduct(productId);
	}
	
	public void displayInventory() {
		System.out.println("Enter productId");
		int productId=sc.nextInt();
		impl.getInventoryProduct(productId);
	}
	
	public void displayUpdatedInventory() {
		System.out.println("Enter productId");
		int productId=sc.nextInt();
		impl.updateInventoryProduct(productId);
	}
	
	public void displayDeletedInventory() {
		System.out.println("Enter productId");
		int productId=sc.nextInt();
		impl.removeInventoryProduct(productId);
	}
}
