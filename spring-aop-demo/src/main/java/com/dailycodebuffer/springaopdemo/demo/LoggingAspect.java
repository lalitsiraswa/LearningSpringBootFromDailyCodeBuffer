package com.dailycodebuffer.springaopdemo.demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // * can be replaced with the return type of the function(void in this case)
    @Before("execution(* com.dailycodebuffer.springaopdemo.demo.ShoppingCart.checkOut())")
    public void logger(){
        System.out.println("Loggers!");
    }
}
