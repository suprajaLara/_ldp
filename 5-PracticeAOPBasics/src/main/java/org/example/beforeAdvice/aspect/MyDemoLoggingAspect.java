package org.example.beforeAdvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of the related advices for logging

    // @Before("execution(public void appDemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(void add*())")
    @Before("execution(* add*())")
    public void beforeForMethodStartingWithAddAdvice(){
        System.out.println("\n>>>>>>..Executing @before advice on method starting with \"add\" and has no params");
    }

    // @Before("execution(* add*(aopDemo.beforeAdvice.Account))")
    // @Before("execution(* add*(aopDemo.beforeAdvice.Account,..))")
    // @Before("execution(* add*(..))") // matches no-arg also
    // @Before("execution(* aopDemo.beforeAdvice.dao.*.*(..))") // match on any return type, any class in package, any method with any no. of params
    @Before("execution(* org.example.beforeAdvice.dao.*.*(..))") //reference to pointcut expression (already declared above)
    public void beforeForAnyAdvice(){
        System.out.println("\n>>>>>>..Executing @before advice on any method");
    }

}
