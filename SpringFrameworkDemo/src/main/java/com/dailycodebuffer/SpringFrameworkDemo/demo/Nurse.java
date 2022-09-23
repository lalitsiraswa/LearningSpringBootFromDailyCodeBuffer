package com.dailycodebuffer.SpringFrameworkDemo.demo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service
//@Repository
//@Controller
//@Component
public class Nurse implements Staff{
    public void assist(){
        System.out.println("Nurse is assisting!");
    }
}
