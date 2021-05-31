package org.example.afterReturning;

import org.example.afterReturning.dao.AccountDAO;
import org.example.afterReturning.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfigPointcut.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = accountDAO.findAccounts();

        System.out.println("\nMain Program: After returning demoApp");

        System.out.println(accountList+"\n");
        //close the context
        context.close();
    }
}
