package org.example.crudOps;

import org.example.crudOps.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        //for Configuration, check import statements, there are two, select appropriate one.
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //this code (for Configuration) worked when jaxb api dependency is added to pom.xml

        //create session
        Session session = factory.getCurrentSession();

        try{
            //create 3 student object
            System.out.println("creating 3 student objects..");
            Student studentObj1 = new Student("John","Doe","john@gmail.com");
            Student studentObj2 = new Student("Mary","Public","mary@gmail.com");
            Student studentObj3 = new Student("Bonita","Apple","apple@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("saving students..");
            session.save(studentObj1);
            session.save(studentObj2);
            session.save(studentObj3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
