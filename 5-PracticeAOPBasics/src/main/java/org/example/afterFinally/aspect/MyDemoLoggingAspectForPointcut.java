package org.example.afterFinally.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.afterFinally.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspectForPointcut {
    //pointcut expressions are defined in AopExpressions java file

    @After("execution(* org.example.afterFinally.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>.. Executing @After (finally) on : "+method);

    }

    @AfterThrowing(
            pointcut = "execution(* org.example.afterFinally.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint, Throwable exception){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>.. Executing @AfterThrowing on : "+method);

        //print exception
        System.out.println("\n=====>.. exception is  : "+exception);
    }

    // add a new advice for @AfterReturning on findAccounts()
    @AfterReturning(
            pointcut = "execution(* org.example.afterFinally.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>.. Executing @AfterReturning on : "+method);

        //print results of method call
        System.out.println("\n=====>.. Result is  : "+result);

        //post processing data....
        //convert account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====>.. Result is  : "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account:result){
            String upperCase = account.getName().toUpperCase();
            account.setName(upperCase);
        }
    }

    @Before("org.example.afterFinally.aspect.AopExpressions.excludeGetterSetter()") //reference to pointcut expression (already declared above)
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
