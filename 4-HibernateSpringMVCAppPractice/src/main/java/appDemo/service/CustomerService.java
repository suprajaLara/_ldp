package appDemo.service;

import appDemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(int customerId);
}
