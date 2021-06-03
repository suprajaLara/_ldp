package appDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations for - service, controller and dao packages
    @Pointcut("execution(* appDemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* appDemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* appDemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    //add @before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> in @Before: calling method: "+method);

        //display arguments to the method
        Object[] args = joinPoint.getArgs();

        for(Object tempArg : args){
            logger.info("\n====>>> argument: "+tempArg);
        }

    }

    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        //display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> in @AfterReturning: from method: "+method);

        //display data returned
        logger.info("\n====>>> result: "+result);
    }

}
