package org.example.aroundWithLogger;

import org.example.aroundWithLogger.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {
    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());//common practice is to use classname
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfigPointcut.class);

        //get the bean from spring container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain program: aroundDemoApp");

        logger.info("calling getFortune");

        String data = fortuneService.getFortune();

        logger.info("\nMy fortune is: "+data);

        logger.info("Finished");
        //close the context
        context.close();
    }
}
