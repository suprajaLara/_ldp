package appDemo.controller;

import appDemo.entity.Customer;
import appDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //remove the customerDao, and inject customerService (new layer)
    //need to inject customer dao
//    @Autowired
//    private CustomerDao customerDao;

    //need to inject customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model){

        //get customers from the dao
//        List<Customer> customerList = customerDao.getCustomers();
        //get customers from the service
        List<Customer> customerList = customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers",customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        //create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        //save the customer
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId,
                                    Model model){
        //get the customer from our service
        Customer customer = customerService.getCustomer(customerId);

        //set customer as a model attribute to pre-populate the form
        model.addAttribute("customer",customer);

        //send over to our form
        return "customer-form";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        //delete the customer
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}
