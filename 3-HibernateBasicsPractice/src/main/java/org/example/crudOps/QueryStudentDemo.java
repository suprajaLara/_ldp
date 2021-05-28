package org.example.crudOps;

import org.example.crudOps.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
//import javax.security.auth.login.Configuration;

public class QueryStudentDemo {
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
            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> students = session.createQuery("from Student").getResultList();
            //display students
            displayStudents(students);

            System.out.println("\n\n");
            //query student with custom lastname
            students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            //display students
            displayStudents(students);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student tempStudent : students) {
            System.out.println(tempStudent);
        }
    }
}
