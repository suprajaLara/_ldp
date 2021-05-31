package org.example.order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspectForPointcut {
    // this is where we add all of the related advices for logging

    //pointcut expressions are defined in AopExpressions java file

    @Before("org.example.order.aspect.AopExpressions.excludeGetterSetter()") //reference to pointcut expression (already declared above)
    public void beforeForAnyAdvice(){
        System.out.println("\n>>>>>>..Executing @before advice on any method");
    }

}
