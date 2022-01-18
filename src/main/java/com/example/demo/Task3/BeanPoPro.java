package com.example.demo.Task3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPoPro implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLifeCycle) {
            System.out.println("--- postProcessAfterInitialization executed ---");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof BeanLifeCycle) {
            System.out.println("--- postProcessBeforeInitialization executed ---");
        }
        return bean;
    }
    }
