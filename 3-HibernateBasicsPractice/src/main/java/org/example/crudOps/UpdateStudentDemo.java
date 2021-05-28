package org.example.crudOps;

import org.example.crudOps.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        //for Configuration, check import statements, there are two, select appropriate one.
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        //this code worked when jaxb api dependency is added to pom.xml

        //create session
        Session session = factory.getCurrentSession();

        try{
            int studentId=1;

            //get a new session, start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on primary key:id
            System.out.println("getting student: "+studentId);
            Student student = session.get(Student.class,studentId);
            System.out.println("updating student..");
            student.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();

            //other way of updating
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("updating student emails");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
