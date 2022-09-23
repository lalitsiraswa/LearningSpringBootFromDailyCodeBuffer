package com.dailycodebuffer.SpringFrameworkDemo.demo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope(scopeName = "singleton") // Default scope of a Bean
public class Doctor implements Staff{

    private String qualification;
    public void assist() {
        System.out.println("Doctor is assisting!");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }
}
