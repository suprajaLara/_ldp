package com.example.practiceSpring;

public class BaseBallCoach implements Coach{

    //defining private field for dependency
    private FortuneService fortuneService;
    //defining constructor for dependency injection
    public BaseBallCoach(FortuneService fortuneService){
        this.fortuneService =fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "workout of Baseball..!";
    }

    @Override
    public String getDailyFortune() {
        //using fortune service to get fortune -- coach needs dependency to get fortune
        return fortuneService.getFortune();
    }
}
