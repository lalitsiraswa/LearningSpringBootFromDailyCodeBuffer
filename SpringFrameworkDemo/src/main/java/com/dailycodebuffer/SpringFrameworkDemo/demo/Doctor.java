package com.dailycodebuffer.SpringFrameworkDemo.demo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Scope(scopeName = "singleton") // Default scope of a Bean
@Component // We need to use this for prototype bean scope
@Scope(scopeName = "prototype") // New object will be created every time
public class Doctor implements Staff, BeanNameAware, InitializingBean, DisposableBean, BeanFactoryAware, ApplicationContextAware {

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
    @Override
    public void setBeanName(String s) {
        System.out.println("Set Bean name method is called : " + s);
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Construct method is called.");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("Pre Destroy Method is called.");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After property set method is called.");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean Destroy method is called.");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("set bean factory method is called.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context aware method is called.");
    }
}
