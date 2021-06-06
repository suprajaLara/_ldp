package com.springBoot.Assignment.controller;

import com.springBoot.Assignment.entity.Customer;
import com.springBoot.Assignment.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listCustomers(Model model){
        //get customers from db
        List<Customer> customers = customerService.findAll();

        //add to spring model
        model.addAttribute("customers",customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customers/customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "customers/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomers(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id){
        customerService.deleteById(id);
        return "redirect:/customers/list";
    }
}
