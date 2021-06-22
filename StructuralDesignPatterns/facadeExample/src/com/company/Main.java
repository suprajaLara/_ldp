package com.company;

public class Main {
    public static void main(String[] args) {
        Facade customerOrder = new Facade();
        customerOrder.orderFood("Pizza");
        System.out.println("===============================================================");
        customerOrder.orderFood("Burger");
        System.out.println("===============================================================");
        customerOrder.orderFood("Biryani");
    }
}
