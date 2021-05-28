package com.example.practiceSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemo {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
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
