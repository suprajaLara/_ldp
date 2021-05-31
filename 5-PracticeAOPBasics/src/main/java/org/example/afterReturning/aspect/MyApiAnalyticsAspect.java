package org.example.afterReturning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("org.example.afterReturning.aspect.AopExpressions.excludeGetterSetter()") //reference to pointcut expression
    public void performAnalytics(){
        System.out.println("\n>>>>>>..Executing performing analytics");
    }
}
