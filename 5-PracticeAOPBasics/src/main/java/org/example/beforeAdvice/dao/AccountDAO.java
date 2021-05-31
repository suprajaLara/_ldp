package org.example.beforeAdvice.dao;

import org.example.beforeAdvice.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
//    public void addAccount(){
//    public boolean addAccount()
//    public boolean addAccount(Account account){
    public boolean addAccount(Account account,boolean vipFlag){
        System.out.println(getClass()+" : Adding account...!");
        return true;
    }

    public boolean doWork(){
        System.out.println(getClass()+" : doWork()");
        return true;
    }
}
