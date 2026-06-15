package com.harshal.orderManagement.exception;

public class GroceryItemNotFoundException extends RuntimeException {
    public GroceryItemNotFoundException(Long id) {
        super("Grocery item not found with id: " + id);
    }
}
