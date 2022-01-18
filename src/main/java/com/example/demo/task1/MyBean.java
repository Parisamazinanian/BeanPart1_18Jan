package com.example.demo.task1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContextAware;

//make it visible for the Spring
@Component
public class MyBean implements ApplicationContextAware {
    //Creating a field of our ApplicationContext
    private static ApplicationContext applicationContext;

    //Creating a getter of the ApplicationContext type

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //using the method in our interface
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
