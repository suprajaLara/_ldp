package com.example.practiceSpring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TestSpringandTomcatApplication {

    public static void main(String[] args) {

//        SpringApplication.run(TestSpringandTomcatApplication.class, args);

        //to load config.. file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //to get bean from spring container
//        Coach coach = context.getBean("myCoach",Coach.class);
        CricketCoach coach = context.getBean("myCricketCoach",CricketCoach.class);

        //to call methods on bean
        System.out.println(coach.getDailyWorkout());

        // calling new fortune method
        System.out.println(coach.getDailyFortune());

        //calling literal values through injection
        System.out.println(coach.getEmailAddress());
        System.out.println(coach.getTeam());

        //to close context
        context.close();
    }

}
