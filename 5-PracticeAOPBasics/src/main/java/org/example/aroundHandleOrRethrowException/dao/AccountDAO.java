package org.example.aroundHandleOrRethrowException.dao;

import org.example.aroundHandleOrRethrowException.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    //add new method findAccounts()
    public List<Account> findAccounts(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Nothing found, there is some error");
        }
        List<Account> accountList = new ArrayList<>();

        //create sample accounts
        Account account1 = new Account("John","Bond");
        Account account2 = new Account("King","George");
        Account account3 = new Account("Adolf","Hitler");

        //add to account list
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;
    }

    public boolean addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+" : Adding account...!");
        return true;
    }

    public boolean doWork(){
        System.out.println(getClass()+" : doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass()+" : getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" : setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" : getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" : setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
