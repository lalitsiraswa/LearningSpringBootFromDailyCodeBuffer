package com.dailycodebuffer.springaopdemo.demo;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(){
        // These are the cross cutting concerns (we need to separate these from the business logic)
        // Logging
        // Authentication & Authorization
        // Sanitize the Data
        System.out.println("Checkout Method From ShoppingCart Called");
    }
}
