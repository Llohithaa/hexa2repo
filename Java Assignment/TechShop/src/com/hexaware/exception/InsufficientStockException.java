package com.hexaware.exception;
public class InsufficientStockException extends RuntimeException{
	
	public InsufficientStockException() {
		super();
		System.out.println("From UNF Constr...");
	}

	public InsufficientStockException(String message) {
		super();
		System.out.println(message);
	}

	@Override
	public String toString() {
		return "UserNotFoundException From ToString()";
	}

}
