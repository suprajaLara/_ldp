package org.example.afterFinally.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
    @Before("org.example.afterFinally.aspect.AopExpressions.excludeGetterSetter()") //reference to pointcut expression
    public void logToCloud(){
        System.out.println("\n>>>>>>..Executing logging to cloud");
    }
}
