package com.example.practiceSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemo {
    public static void main(String[] args) {
        //load config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_lifecycle_applicationContext.xml");

        //retrieve bean
        Coach coach = context.getBean("myCoach",Coach.class);

        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}
