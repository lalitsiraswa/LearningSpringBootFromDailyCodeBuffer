package com.dailycodebuffer.springaopdemo.demo;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(String status){
        // These are the cross cutting concerns (we need to separate these from the business logic)
        // Logging
        // Authentication & Authorization
        // Sanitize the Data
        System.out.println("Checkout Method From ShoppingCart Called");
    }
    public void testFunction(){
        System.out.println("Test Method From ShoppingCart Called");
    }
}
