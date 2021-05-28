package com.example.practiceSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemo {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        //get bean from spring container
        SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
        //call a method on bean
        System.out.println(coach.getDailyWorkout());
        // call method to get daily fortune (dependency injection)
        System.out.println(coach.getDailyFortune());

        System.out.println("email: "+coach.getEmail());
        System.out.println("team: "+coach.getTeam());

        //close context
        context.close();
    }
}
