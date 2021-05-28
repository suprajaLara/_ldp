package com.example.practiceSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("tennisCoachBeanId")    //spring registers this bean automatically
@Component
//@Scope("prototype") // by default it is @Scope("singleton")
public class TennisCoach implements Coach{

    //annotation applied directly on the field.
    // when spring creates the object then it automatically sets this field behind the scene
    // this java technology called reflection
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    /***
    //create constructor and pass in dependency
    //@Autowired implies - we want spring to automatically wire up this component(fortuneService)
    //to satisfy the dependency(fortuneService), spring scans components,( refer - HappyFortuneService_usingAnnotation class)
    // finds the component that implements FortuneService interface, take that bean,
    // inject it or autowire it, into tennis coach(for example in this case)
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService=fortuneService;
    }
    ***/

    public TennisCoach(){
        System.out.println("inside tennis coach no-arg constructor.....!");
    }

    //defining init method
    @PostConstruct
    public void doStartUp(){
        System.out.println("STARTING UP RESOURCES");
    }

    //defining destroy method
    @PreDestroy
    public void doCleanUp(){
        System.out.println("CLEANING UP RESOURCES");
    }

    /***
    //defining setter method - for setter injection, autowire dependency using setter
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside fortuneService setter");
        this.fortuneService = fortuneService;
    }
    ***/

    /***
     // annotation can be applied to any method, to inject dependency, not only the setter method
    @Autowired
    public void doSomethingCrazy(FortuneService fortuneService){
        System.out.println("inside fortuneService setter - doSomethingCrazy");
        this.fortuneService = fortuneService;
    }
    ***/
    @Override
    public String getDailyWorkout() {
        return "practice tennis..!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
