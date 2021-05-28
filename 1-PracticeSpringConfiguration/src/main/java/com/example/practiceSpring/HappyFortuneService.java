package com.example.practiceSpring;

public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "hello from HappyFortuneService";
    }
}
