package org.example.joinPoint;

import org.example.joinPoint.dao.AccountDAO;
import org.example.joinPoint.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfigPointcut.class);

        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //call the account business method
        Account account = new Account();
        account.setLevel("silver");
        account.setName("hello");
        accountDAO.addAccount(account,true);
        accountDAO.doWork();
        // call getters and setters
        accountDAO.setName("foo");
        accountDAO.setServiceCode("silver");
        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        //call the membership business method
        membershipDAO.addMember();
        membershipDAO.getJumps();

        //close the context
        context.close();
    }
}
