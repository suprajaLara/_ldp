package com.company;

public class WaiterImpl implements Waiter{
    @Override
    public void writeOrder(String item) {
        System.out.println("Item:"+item+", is ordered");
    }

    @Override
    public void sendToKitchen() {
        System.out.println("Order is sent to kitchen");
    }

    @Override
    public void serveCustomer() {
        System.out.println("Order is delivered to customer");
    }
}
