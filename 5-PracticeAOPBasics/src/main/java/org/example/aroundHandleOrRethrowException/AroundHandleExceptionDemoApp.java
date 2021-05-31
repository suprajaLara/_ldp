package org.example.aroundHandleOrRethrowException;

import org.example.aroundHandleOrRethrowException.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());//common practice is to use classname
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfigPointcut.class);

        //get the bean from spring container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain program: aroundDemoApp");

        logger.info("calling getFortune");

        boolean tripWire = true;
        //this will never know about exception, as it is handled by @Around
        String data =fortuneService.getFortune(tripWire);

        logger.info("\nMy fortune is: "+data);

        logger.info("Finished");
        //close the context
        context.close();
    }
}
