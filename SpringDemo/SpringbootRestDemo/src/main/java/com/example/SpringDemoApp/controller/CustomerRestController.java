package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.dto.CustomerDto;
import com.example.SpringDemoApp.entity.Customer;
import com.example.SpringDemoApp.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;

    // add mapping for get /customers
    @GetMapping("/customers")
    public List<CustomerDto> getCustomers(){
        // convert entity to DTO
        return customerService.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer,CustomerDto.class))
                .collect(Collectors.toList());
    }

    // add mapping for get /customer
    @GetMapping("/customers/{customerId}")
    public CustomerDto getCustomer(@PathVariable int customerId){

        Customer customer = customerService.findById(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Customer id not found: "+customerId);
        }

        // convert entity to DTO
        return modelMapper.map(customer,CustomerDto.class);
    }

    // add mapping for POST /customers - add new customer
    @PostMapping("/customers")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto){
        //convert DTO to Entity
        Customer customerRequest = modelMapper.map(customerDto,Customer.class);

        //check if customer is new
        Customer customer = null;
        try {
            customer = customerService.findById(customerRequest.getId());
        }
        catch (Exception e){}

        if(customer!=null){
            throw new RuntimeException("Customer with given id is already present");
        }

        //pass id, set as 0, to force a save of new customer, instead of update
        customerRequest.setId(0);
        customerService.save(customerRequest);

        // convert entity to DTO
        CustomerDto customerDtoResponse = modelMapper.map(customerRequest,CustomerDto.class);
        return new ResponseEntity<CustomerDto>(customerDtoResponse, HttpStatus.CREATED);
    }

    // add mapping for PUT /customers - update customer
    @PutMapping("/customers")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){

        //convert DTO to Entity
        Customer customerRequest = modelMapper.map(customerDto,Customer.class);

        //check if customer is already present or not
        Customer customer = customerService.findById(customerRequest.getId());

        customerService.save(customer);

        return ResponseEntity.ok().body(customerDto);
    }

    // add mapping for DELETE /customers/{customerId} - update customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        //if customer not found, exception is raised at customer service
        Customer customer = customerService.findById(customerId);

        customerService.deleteById(customerId);

        return "Deleted customer id - "+customerId;
    }
}
