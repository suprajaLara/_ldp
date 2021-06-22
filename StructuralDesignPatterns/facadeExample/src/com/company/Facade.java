package com.company;

public class Facade {
    Waiter waiter = new WaiterImpl();

    public void orderFood(String item){
        switch (item){
            case "Pizza": processOrder(item,new Pizza(),waiter);
                          break;
            case "Burger": processOrder(item,new Burger(),waiter);
                           break;
            default: System.out.println("item: "+item+", is not available");
        }
    }

    public void processOrder(String item, Kitchen kitchen, Waiter waiter){
        waiter.writeOrder(item);
        waiter.sendToKitchen();
        kitchen.prepareFood();
        kitchen.callWaiter();
        waiter.serveCustomer();
    }
}
