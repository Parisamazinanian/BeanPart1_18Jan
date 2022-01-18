package com.example.demo;

import com.example.demo.Task3.BeanLifeCycle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Task3Test {

    @Autowired
    public BeanLifeCycle beanLifeCycle;

    @Test
    public void testMySpringBeanLifecycle() {
        String message = "Parisa is happy";
        beanLifeCycle.setMessage(message);
        Assertions.assertEquals(message, beanLifeCycle.getMessage());

        System.out.println("The message is: " + beanLifeCycle.getMessage());
    }
}
