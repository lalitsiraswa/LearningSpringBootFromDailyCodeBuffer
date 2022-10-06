package com.dailycodebuffer.springaopdemo.demo;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // * can be replaced with the return type of the function(void in this case)
    @Before("execution(* com.dailycodebuffer.springaopdemo.demo.ShoppingCart.checkOut(..))")
    public void beforeLogger(){
        System.out.println("Before Loggers!");
    }
//    @After("execution(* com.dailycodebuffer.springaopdemo.demo.ShoppingCart.checkOut(..))")
    @After("execution(* *.*.*.*.*.checkOut(..))") // first * == "Any return type" 2nd * == "com" and 3rd * == "dailycodebuffer" 4th * == "springaopdemo" 5th * == "demo" and 6th * == "ShoppingCart"
    public void afterLogger(){
        System.out.println("After Loggers!");
    }
}
