package com.dailycodebuffer.springaopdemo.demo;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(){
        System.out.println("Checkout Method From ShoppingCart Called");
    }
}
