package com.hexaware.controller;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.OrderImplementation;
import com.hexaware.model.Customers;
import com.hexaware.model.Orders;
import com.hexaware.model.Products;
public class OrderController {
	Orders order;
	Scanner sc=new Scanner(System.in);
	OrderImplementation orderDao=new OrderImplementation();
	OrderDetailController od1=new OrderDetailController();
	
	public void displayAddedOrder() {
		od1.displayAddOrderDetails();
		od1.displayTotalAmount();
		System.out.println("Enter CustomerId:");
		int customerId=sc.nextInt();
		orderDao.placeAnOrder(customerId);
		System.out.println("Order Amount: " + order.setTotalAmount());
		System.out.println("Order Placed... Your OrderId is :" + order.getOrderId());
	}
	
	public void displayUpdateOrder() {
		System.out.println("Enter OrderId:");
		int orderId=sc.nextInt();
		orderDao.updateOrder(orderId);
	}
	
	public void displayDeletedOrder() {
		System.out.println("Enter OrderId:");
		int orderId=sc.nextInt();
		orderDao.removeOrder(orderId);
	}
	
	public void displayGetOrder() {
		System.out.println("Enter OrderId:");
		int orderId=sc.nextInt();
		List<Orders> orders = orderDao.getOrders(orderId);
        System.out.println("Customer Details: ");
        for (Orders order : orders) {
            System.out.println(order);
        }
	}
}
