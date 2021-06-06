package com.springboot.crud.SpringBootJpaCrudDemo.dao;

import com.springboot.crud.SpringBootJpaCrudDemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    @Transactional //use "import org.springframework.transaction.annotation.Transactional;"
    public List<Employee> findAll() {
        //get current hibernate session
        //use "import org.hibernate.Session;"
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        //use "import org.hibernate.query.Query;"
        Query<Employee> query =
                currentSession.createQuery("from Employee",Employee.class);

        //execute query and get result
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class,id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class,id);
        currentSession.delete(employee);
//        Query theQuery =
//                currentSession.createQuery("delete from Employee where id=:empId");
//        theQuery.setParameter("empId", id);
//
//        theQuery.executeUpdate();
    }
}
