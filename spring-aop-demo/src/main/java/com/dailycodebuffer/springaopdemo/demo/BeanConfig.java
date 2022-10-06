package com.dailycodebuffer.springaopdemo.demo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.dailycodebuffer.springaopdemo.demo")
@EnableAspectJAutoProxy
public class BeanConfig {
}
