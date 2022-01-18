package com.example.demo;

import com.example.demo.task1.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

//@SpringBootTest annotation, which runs the application in a test context
@SpringBootTest
class DemoApplicationTests {
	//You are to inject your ApplicationContextAware bean here to the test class.
	// You can achieve that with the @Autowired, injecting directly to the field.
	@Autowired private MyBean myBean;

	@Test
	void contextLoads() {}

	//Test 1
	@Test
	public void appContextNotNull(){
		Assertions.assertNotNull(myBean);
	}

	//Test2
	@Test
	public void appContext_getByName(@Autowired Bean1 bean1){
		Assertions.assertNotNull(bean1);
		ApplicationContext applicationContext = MyBean.getApplicationContext();
		Assertions.assertEquals(bean1, applicationContext.getBean("bean1"));
	}

	@Test
	void appContext_getByType(@Autowired Bean2 bean2) {
		Assertions.assertNotNull(bean2);
		ApplicationContext applicationContext = MyBean.getApplicationContext();
		Assertions.assertEquals(bean2, applicationContext.getBean(Bean2.class));
	}

	@Test
	void appContext_getByNameAndType(@Autowired Bean3 bean3) {
		Assertions.assertNotNull(bean3);
		ApplicationContext applicationContext = MyBean.getApplicationContext();
		Assertions.assertEquals(bean3, applicationContext.getBean("bean3", Bean3.class));
	}



}
