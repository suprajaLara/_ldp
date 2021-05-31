package org.example.aroundHandleOrRethrowException.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
    @Pointcut("execution(* org.example.aroundHandleOrRethrowException.dao.*.*(..))")
    public void forDaoPackage(){}

    //create pointcut for getter methods
    @Pointcut("execution(* org.example.aroundHandleOrRethrowException.dao.*.get*(..))")
    public void getter(){}

    //create pointcut for setter methods
    @Pointcut("execution(* org.example.aroundHandleOrRethrowException.dao.*.set*(..))")
    public void setter(){}

    //create pointcut: include package , exclude getter/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void excludeGetterSetter(){}
}
