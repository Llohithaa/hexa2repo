package com.hexaware.dao;
import com.hexaware.model.Orders;
import java.time.LocalDate;
import com.hexaware.exception.DatabaseAccessException;
import java.util.List;

public interface OrderInterface {
	List<Orders> getAllOrders() throws DatabaseAccessException;

    Orders getOrderById(int orderId) throws DatabaseAccessException;

    void addOrder(Orders order) throws DatabaseAccessException;

    void updateOrderStatus(int orderId, String newStatus) throws DatabaseAccessException;

    void removeOrder(Orders order) throws DatabaseAccessException;
    
    List<Orders> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) throws DatabaseAccessException;

    List<Orders> getOrdersSortedByDate(boolean ascending) throws DatabaseAccessException;
}
