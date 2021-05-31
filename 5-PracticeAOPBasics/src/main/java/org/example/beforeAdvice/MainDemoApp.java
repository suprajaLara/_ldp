package org.example.beforeAdvice;

import org.example.beforeAdvice.dao.AccountDAO;
import org.example.beforeAdvice.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO accountDAOForPointcut = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //call the account business method
        Account account = new Account();
        accountDAOForPointcut.addAccount(account,true);
        accountDAOForPointcut.doWork();

        //call the membership business method
        membershipDAO.addMember();
        membershipDAO.getJumps();

        //close the context
        context.close();
    }
}
