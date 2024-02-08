package com.hexaware.exception;

public class DatabaseAccessException extends RuntimeException {

    public DatabaseAccessException() {
        super("Database access error.");
    }

    public DatabaseAccessException(String message) {
        super(message);
    }

    public DatabaseAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
