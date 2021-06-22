package com.company;

public class Pizza implements Kitchen{
    @Override
    public void prepareFood() {
        System.out.println("Preparing Pizza");
    }

    @Override
    public void callWaiter() {
        System.out.println("Calling waiter to serve the Pizza");
    }
}
