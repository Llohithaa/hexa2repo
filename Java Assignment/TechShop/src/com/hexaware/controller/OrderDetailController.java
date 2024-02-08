package com.hexaware.controller;

import com.hexaware.dao.OrderDetailsImplementation;
import com.hexaware.model.OrderDetails;
import java.util.Scanner;
public class OrderDetailController {
	Scanner sc = new Scanner(System.in);
	OrderDetails orderDetails;
	OrderDetailsImplementation orderDetailDao = new OrderDetailsImplementation();
	public void displayAddOrderDetails() {
		System.out.println("Enter orderDetailId:");
		int orderDetailId=sc.nextInt();
		System.out.println("Enter orderId:");
		int orderId=sc.nextInt();
		System.out.println("Enter ProductId:");
		int productId=sc.nextInt();
		System.out.println("Enter Quantity:");
		int quantity = sc.nextInt();
		orderDetails=new OrderDetails(orderDetailId, orderId, productId, quantity);
		orderDetailDao.addOrderDetails(orderDetails);
	}
	
	public void displayTotalAmount() {
		System.out.println("Enter orderId:");
		int orderId=sc.nextInt();
		System.out.println("Enter Quantity:");
		int quantity = sc.nextInt();
		orderDetailDao.calculateTotalAmount(orderId, quantity);
		
	}
	
	public void displayUpdatedOrderDetails() {
		System.out.println("Enter orderId:");
		int orderId=sc.nextInt();
		System.out.println("Enter Quantity:");
		int quantity = sc.nextInt();
		orderDetailDao.updateOrderDetails(orderId, quantity);
	}
	
	public void displayDeletedOrderDetails() {
		System.out.println("Enter orderId:");
		int orderId=sc.nextInt();
		orderDetailDao.removeOrderDetails(orderId);
	}

}
