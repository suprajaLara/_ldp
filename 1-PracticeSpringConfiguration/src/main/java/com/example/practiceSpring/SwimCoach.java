package com.example.practiceSpring;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${x.email}")
    private String email;

    @Value("${x.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "swim daily..!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
