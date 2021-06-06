package com.springBoot.Assignment.dao;

import com.springBoot.Assignment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public List<Customer> findAllByOrderByLastNameAsc();
}
