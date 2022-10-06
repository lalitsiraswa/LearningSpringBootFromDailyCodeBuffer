package com.dailycodebuffer.springaopdemo.demo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // * can be replaced with the return type of the function(void in this case)
    @Before("execution(* com.dailycodebuffer.springaopdemo.demo.ShoppingCart.checkOut(..))")
    public void beforeLogger(JoinPoint joinPoint){
//        System.out.println(joinPoint.getSignature());
//        System.out.println(joinPoint.getArgs()[0]);
        String arg = joinPoint.getArgs()[0].toString();
        System.out.println("Before Loggers! with argument : " + arg);
    }
//    @After("execution(* com.dailycodebuffer.springaopdemo.demo.ShoppingCart.checkOut(..))")
    @After("execution(* *.*.*.*.*.checkOut(..))") // first * == "Any return type" 2nd * == "com" and 3rd * == "dailycodebuffer" 4th * == "springaopdemo" 5th * == "demo" and 6th * == "ShoppingCart"
    public void afterLogger(JoinPoint joinPoint){
//        System.out.println(joinPoint.getSignature());
//        System.out.println(joinPoint.getArgs()[0]);
        String arg = joinPoint.getArgs()[0].toString();
        System.out.println("After Loggers! with argument : " + arg);
    }
    @Pointcut("execution(* com.dailycodebuffer.springaopdemo.demo.ShoppingCart.quantity())")
    public void afterReturningPointCut(){

    }
    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(int retVal){
        System.out.println("After Returning with return value : " + retVal);
    }
}
