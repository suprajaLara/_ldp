package com.example.practiceSpring;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    //new fields to show literal injection
    private String emailAddress;
    private String team;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("inside setter method of cricketCoach - setEmailAddr");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("inside setter method of cricketCoach - setTeam");
        this.team = team;
    }

    public CricketCoach() {
        System.out.println("inside cricketCoach constructor");
    }

    //this setter method gets called by spring when we inject dependency
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside setter method of cricketCoach - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice bowling and batting";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
