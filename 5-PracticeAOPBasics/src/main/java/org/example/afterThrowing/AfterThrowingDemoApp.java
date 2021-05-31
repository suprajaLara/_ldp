package org.example.afterThrowing;

import org.example.afterThrowing.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfigPointcut.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = null;
        try {
            //add boolean flag to simulate exception
            boolean tripWire = true;
            accountList = accountDAO.findAccounts(tripWire);
        }catch (Exception e){
            System.out.println("\nMain program..exception "+e);
        }

        System.out.println("\nMain Program: AfterThrowingDemoApp");

        System.out.println(accountList+"\n");
        //close the context
        context.close();
    }
}
