package org.example.pointcutDeclarations.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectForPointcut {
    // this is where we add all of the related advices for logging

    @Pointcut("execution(* org.example.pointcutDeclarations.dao.*.*(..))")
    private void forDaoPackage(){}

    //create pointcut for getter methods
    @Pointcut("execution(* org.example.pointcutDeclarations.dao.*.get*(..))")
    private void getter(){}

    //create pointcut for setter methods
    @Pointcut("execution(* org.example.pointcutDeclarations.dao.*.set*(..))")
    private void setter(){}

    //create pointcut: include package , exclude getter/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void excludeGetterSetter(){}

    @Before("excludeGetterSetter()") //reference to pointcut expression (already declared above)
    public void beforeForAnyAdvice(){
        System.out.println("\n>>>>>>..Executing @before advice on any method");
    }

    @Before("excludeGetterSetter()") //reference to pointcut expression (already declared above)
    public void performAnalytics(){
        System.out.println("\n>>>>>>..Executing @before advice for performing analytics");
    }


}
