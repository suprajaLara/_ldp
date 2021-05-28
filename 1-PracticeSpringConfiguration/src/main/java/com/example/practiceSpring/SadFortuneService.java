package com.example.practiceSpring;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "sad fortune coming up.. :(";
    }
}
