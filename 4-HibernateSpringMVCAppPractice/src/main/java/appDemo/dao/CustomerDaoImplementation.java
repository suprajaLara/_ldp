package appDemo.dao;

import appDemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDaoImplementation implements CustomerDao{

    //need to inject session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
//    @Transactional
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query, sort by first name
        Query<Customer> customerQuery = currentSession.createQuery("from Customer order by firstName",Customer.class);

        //execute query and get result list
        List<Customer> customers = customerQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save the customer
//        currentSession.save(theCustomer);
        currentSession.saveOrUpdate(theCustomer);
    }


    @Override
    public Customer getCustomer(int customerId) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //retrieve from db using primary key
        Customer customer = currentSession.get(Customer.class,customerId);
        return customer;
    }

    @Override
    public void deleteCustomer(int customerId) {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //delete object with primary key
        Query query = currentSession
                        .createQuery("delete from Customer where id=:id"); //second id is the name of id variable in customer class
        query.setParameter("id",customerId);

        query.executeUpdate();
    }
}
