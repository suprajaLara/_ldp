package org.example.joinPoint.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.joinPoint.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspectForPointcut {
    // this is where we add all of the related advices for logging

    //pointcut expressions are defined in AopExpressions java file

    @Before("org.example.joinPoint.aspect.AopExpressions.excludeGetterSetter()") //reference to pointcut expression (already declared above)
    public void beforeForAnyAdvice(JoinPoint joinPoint) {
        System.out.println("\n>>>>>>..Executing @before advice on any method");


        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        //display method args
        //get args
        Object[] args = joinPoint.getArgs();

        //loop through args
        for (Object tempArg : args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                //downcast and print Account specific info
                Account account = (Account)  tempArg;
                System.out.println(account.getName());
                System.out.println(account.getLevel());
            }
        }

    }
}
