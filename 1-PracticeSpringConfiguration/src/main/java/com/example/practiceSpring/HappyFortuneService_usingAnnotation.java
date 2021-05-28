package com.example.practiceSpring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService_usingAnnotation implements FortuneService{
    @Override
    public String getFortune() {
        return "hello from HappyFortuneService";
    }
}
