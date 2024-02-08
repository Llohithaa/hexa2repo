package com.hexaware.model;

public class Orders {
	private int orderId;
	private int customerId;
	private String orderDate;
	private double totalAmount;
	private String status;
	Products prd = new Products();
	
	//Default constructor
	public Orders(){
			
	}
		
	//Parameterized constructor
	public Orders(int orderId, int customerId, String orderDate, double totalAmount, String status){
		super();
		this.orderId=orderId;
		this.customerId=customerId;
		this.orderDate=orderDate;
		this.totalAmount=totalAmount;
	}
	
	//getters and setters
	public int getOrderId() {
		return orderId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public double setTotalAmount() {
		return totalAmount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setOrderId() {
		int orderId=this.orderId;
		this.orderId=orderId;
	}
	
	public void setcustomerId(int customerId) {
		this.customerId=customerId;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate=orderDate;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount=totalAmount;
	}
	
	public double calculateTotalAmount(int quantity) {
		totalAmount=quantity*(prd.getPrice());
		return totalAmount;
	}
	
	public void getOrderDetails() {
		System.out.println("OrderId:" + orderId + "\nCustomerId:" + customerId + "\nOrderDate:" + orderDate + "\nTotalAmount:" + totalAmount);
	}
	
	public void updateOrderStatus() {
		
	}
	
	public void cancelOrder() {
		
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", status=" + status + ", prd=" + prd + "]";
	}
	
	
}
