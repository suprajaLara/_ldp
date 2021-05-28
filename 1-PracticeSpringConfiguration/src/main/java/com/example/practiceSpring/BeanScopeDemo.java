package com.example.practiceSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {
    public static void main(String[] args) {
        //load config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_scope_applicationContext.xml");

        //retrieve bean
        Coach coach = context.getBean("myCoach",Coach.class);
        Coach coach2 = context.getBean("myCoach",Coach.class);

        //checking if both are equal
        boolean isEqual = (coach==coach2);
        System.out.println("pointing to same object...!"+isEqual);
        System.out.println("memory locations:"+coach+","+coach2);
    }
}
