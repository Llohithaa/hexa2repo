package com.hexaware.dao;
import com.hexaware.model.OrderDetails;
import com.hexaware.exception.DatabaseAccessException;

public interface OrderDetailsInterface {
	void addOrderDetails(OrderDetails orderDetails) throws DatabaseAccessException;
}
