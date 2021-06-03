package appDemo.dao;

import appDemo.entity.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(int customerId);
}
