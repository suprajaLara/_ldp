package org.example.aroundHandleOrRethrowException.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune(){
        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return a fortune
        return "expect heavy traffic..";
    }
    public String getFortune(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Major accident! ");
        }
        return getFortune();
    }
}
