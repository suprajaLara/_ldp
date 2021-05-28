package com.example.practiceSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/Form")
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloWorldForm";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }

    // method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
//    public String makeCapital(HttpServletRequest request, Model model){
    public String makeCapital(@RequestParam("studentName") String name, Model model){
        //@RequestParam - allow to read form data, & automatically bind it to a parameter(name) coming into the method

        //read request parameter from html form
//        String name = request.getParameter("studentName");

        name = name.toUpperCase();
        String message = "Yo! "+name;

        //add message to the model
        model.addAttribute("message",message);

        return "helloWorld";
    }
}
