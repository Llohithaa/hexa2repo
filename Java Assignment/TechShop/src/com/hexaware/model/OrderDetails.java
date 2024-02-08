package com.hexaware.model;

public class OrderDetails {
	private int orderDetailId;
	private int orderId;
	private int productId;
	private int quantity;
	
	//Default constructor
	public OrderDetails(){
				
	}
			
	//Parameterized constructor
	public OrderDetails(int orderDetailId, int orderId, int productId, int quantity){
		super();
		this.orderDetailId=orderDetailId;
		this.orderId=orderId;
		this.productId=productId;
		this.quantity=quantity;
	}
	
	//getters and setters
	public int getOrderDetailId() {
		return orderDetailId;
	}
	
	public int getorderId() {
		return orderId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId=orderDetailId;
	}
	
	public void setOrder(int orderId) {
		this.orderId=orderId;
	}
	
	public void setProduct(int productId) {
		this.productId=productId;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	public void calculateSubtotal() {
		
	}
	
	public void getOrderDetailInfo() {
		System.out.println("OrderDetailId" + orderDetailId + "\nOrder" + orderId + "\nProduct" + productId + "Quantity" + quantity);
	}
	
	public void updateQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	public void addDiscount() {
		
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}
	
	
}
