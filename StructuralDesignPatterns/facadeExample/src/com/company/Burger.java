package com.company;

public class Burger implements Kitchen{
    @Override
    public void prepareFood() {
        System.out.println("Preparing Burger");
    }

    @Override
    public void callWaiter() {
        System.out.println("Calling waiter to serve the Burger");
    }
}
