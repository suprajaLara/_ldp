package com.example.practiceSpring;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    //create array of strings
    private String[] data ={
            "writing something in line 1 for fortune",
            "writing something in line 2 for fortune",
            "writing something in line 3 for fortune"
    };

    //create random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        //pick random string based on size of array
        int index = random.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;
    }
}
