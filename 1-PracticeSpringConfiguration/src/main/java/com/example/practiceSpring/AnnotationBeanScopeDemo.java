package com.example.practiceSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {
    public static void main(String[] args) {
        //load config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("component_annotation_applicationContext.xml");

        //retrieve bean
        Coach coach = context.getBean("tennisCoach",Coach.class);
        Coach coach2 = context.getBean("tennisCoach",Coach.class);

        //checking if both are equal
        boolean isEqual = (coach==coach2);
        System.out.println("pointing to same object...!"+isEqual);
        System.out.println("memory locations:"+coach+","+coach2);

        context.close();
    }
}
