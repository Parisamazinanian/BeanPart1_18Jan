package com.example.demo;

import com.example.demo.Task2.beans.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class Task2Test {
    @Autowired
    ApplicationContext applicationContext;
    private static final String NAME_1="Jack James";
    private static final String NAME_2="Hill Downhill";
//Test 2.1 - Testing Singleton Scope
    @Test
    public void testingSingletone() {
        //Create two variables of type Person (i.e. person1 and person2) and assign to them the bean
        // captured from the applicationContext. To not conflict with the next test, make sure
        // to get the bean using both the name and the type
        Person person1 = applicationContext.getBean("personSingleton", Person.class);
        Person person2 = applicationContext.getBean("personSingleton", Person.class);
        //Using the setter, assign the first name
        // (NAME_1) to only one of the variables, i.e. to person1
        person1.setName(NAME_1);
        //Assert that the actual value of both person1.getName()
        // and person2.getName() should be the value of NAME_1
        Assertions.assertEquals(NAME_1, person1.getName());
        Assertions.assertEquals(NAME_1, person2.getName());
        //Now, assign the value of NAME_2 to only one of the variables, i.e. to `person2
        person2.setName(NAME_2);
        //Assert again that both person1.getName() and person2.getName() should be the value of NAME_2
        Assertions.assertEquals(NAME_2, person1.getName());
        Assertions.assertEquals(NAME_2, person2.getName());
    }

    //Task 2.2 - Prototype Scope

    @Test
    public void givenPrototypeScope_whenSetName_thenDifferentNames() {
        //Create two variables of type Person (i.e. person1 and person2) and assign to
        // them the bean captured from the applicationContext.
        // To not conflict with the next test, make sure to get the bean using both the name and the type;
        Person person1 = applicationContext.getBean("personPrototype", Person.class);
        Person person2 = applicationContext.getBean("personPrototype", Person.class);
        //Using the setter, assign the first name (NAME_1) to person1
        person1.setName(NAME_1);
        //Now, assert that person1.getName() should be NAME_1, and person2.getName() should be null
        Assertions.assertEquals(NAME_1, person1.getName());
        Assertions.assertNull(person2.getName());
        //Set the name of person2 to NAME_2
        person2.setName(NAME_2);
        //Assert that person1.getName() should be NAME_1 and person2.getName() should be NAME_2
        Assertions.assertEquals(NAME_1, person1.getName());
        Assertions.assertEquals(NAME_2, person2.getName());
    }
}
