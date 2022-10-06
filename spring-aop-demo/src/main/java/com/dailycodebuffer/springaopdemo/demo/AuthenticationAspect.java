package com.dailycodebuffer.springaopdemo.demo;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {
    @Pointcut("within(com.dailycodebuffer.springaopdemo.demo.ShoppingCart)")
    public void authenticatingPointCut(){
        System.out.println("AuthenticatingPintCut Called!");
    }
//    @Pointcut("within(com.dailycodebuffer.springaopdemo.demo.ShoppingCart)")
    @Pointcut("within(com.dailycodebuffer.springaopdemo.demo..*)")
    public void authorizationPointCut(){
        System.out.println("AuthorizationPointCut Called!");
    }
    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authenticating the request");
    }
}
