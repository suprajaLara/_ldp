package springSecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    //added request mapping for leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }
    //added request mapping for leaders
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
}
