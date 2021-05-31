package org.example.aroundHandleOrRethrowException.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aroundHandleOrRethrowException.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspectForPointcut {
    //pointcut expressions are defined in AopExpressions java file

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* org.example.aroundHandleOrRethrowException.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        // print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n==>>>> Executing @Around on method: "+method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        // execute method
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception e){
            //log the exception
            logger.warning(e.getMessage());

            //rethrow exception
            throw e;

            //handle exception
//            //give user a custom message
//            result = "Major accident!..private vehicle on the way";
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end-begin;
        logger.info("\n===>>>> Duration: "+duration/1000.0+" seconds");

        return result;
    }

    @After("execution(* org.example.aroundHandleOrRethrowException.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>.. Executing @After (finally) on : "+method);

    }

    @AfterThrowing(
            pointcut = "execution(* org.example.aroundHandleOrRethrowException.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint, Throwable exception){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>.. Executing @AfterThrowing on : "+method);

        //print exception
        logger.info("\n=====>.. exception is  : "+exception);
    }

    // add a new advice for @AfterReturning on findAccounts()
    @AfterReturning(
            pointcut = "execution(* org.example.aroundHandleOrRethrowException.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        //print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>.. Executing @AfterReturning on : "+method);

        //print results of method call
        logger.info("\n=====>.. Result is  : "+result);

        //post processing data....
        //convert account names to uppercase
        convertAccountNamesToUpperCase(result);
        logger.info("\n=====>.. Result is  : "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account:result){
            String upperCase = account.getName().toUpperCase();
            account.setName(upperCase);
        }
    }

    @Before("org.example.aroundHandleOrRethrowException.aspect.AopExpressions.excludeGetterSetter()") //reference to pointcut expression (already declared above)
    public void beforeForAnyAdvice(JoinPoint joinPoint) {
        logger.info("\n>>>>>>..Executing @before advice on any method");


        //display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: "+methodSignature);

        //display method args
        //get args
        Object[] args = joinPoint.getArgs();

        //loop through args
        for (Object tempArg : args){
            logger.info(tempArg.toString());
            if(tempArg instanceof Account){
                //downcast and print Account specific info
                Account account = (Account)  tempArg;
                logger.info(account.getName());
                logger.info(account.getLevel());
            }
        }

    }
}
