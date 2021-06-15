package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(int id);

    public void save(Customer employee);

    public void deleteById(int id);

}
