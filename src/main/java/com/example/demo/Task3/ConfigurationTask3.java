package com.example.demo.Task3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTask3 {
    @Bean
    public BeanPoPro myBeanPostProcessor() {
        return new BeanPoPro();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public BeanLifeCycle lifeCycleBean() {
        return new BeanLifeCycle();
    }
}
