package com.example.demo.Task3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLifeCycle implements BeanNameAware, ApplicationContextAware, BeanFactoryAware,
        InitializingBean, DisposableBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public void setBeanName(String name){
        System.out.println("--- setBeanName executed ---");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("--- setApplicationContext executed ---");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("--- setBeanFactory executed ---");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--- afterPropertiesSet executed ---");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("--- destroy executed ---");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("--- @PostConstruct executed ---");
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("--- @PreDestroy executed ---");
    }
    public void initMethod() {
        System.out.println("--- initMethod executed ---");
    }

    public void destroyMethod() {
        System.out.println("--- destroyMethod executed ---");
    }
}
