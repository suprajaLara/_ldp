package com.example.practiceSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {
    public static void main(String[] args) {
        //read config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("component_annotation_applicationContext.xml");
        //get bean from spring container
        Coach coach = context.getBean("tennisCoach",Coach.class);
        //call a method on bean
        System.out.println(coach.getDailyWorkout());
        // call method to get daily fortune (dependency injection)
        System.out.println(coach.getDailyFortune());
        //close context
        context.close();
    }
}
