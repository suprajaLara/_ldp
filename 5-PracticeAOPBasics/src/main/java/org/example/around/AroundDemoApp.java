package org.example.around;

import org.example.around.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfigPointcut.class);

        //get the bean from spring container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain program: aroundDemoApp");

        System.out.println("calling getFortune");

        String data = fortuneService.getFortune();

        System.out.println("\nMy fortune is: "+data);

        //close the context
        context.close();
    }
}
