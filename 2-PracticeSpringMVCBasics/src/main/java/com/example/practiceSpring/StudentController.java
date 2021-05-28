package com.example.practiceSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showForm")
    public String showPhone(Model model){
        Student student = new Student();

        //add object to the model
        model.addAttribute("student",student);

        return "student-form";
    }

    @RequestMapping("/processForm")
    //when we send model attribute, form data populates the student object, and we can access it
    // no need of using request mappings, to get student object
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("Student: "+student.getFirstName()+
                " "+student.getLastName());
        return "student-confirmation";
    }
}
