package com.example.practiceSpring;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "daily workout of track coach..!";
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    void doInitialize(){
        System.out.println("entered initialization meth");
    }
    void doDestroy(){
        System.out.println("entered destruction meth");
    }
}
