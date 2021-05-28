package org.example.crudOps;

import org.example.crudOps.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class ReadStudentDemo {
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
            //create a student object
            System.out.println("creating new student object..");
            Student studentObj = new Student("Daffy","Basa","daffy@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("saving student.."+studentObj);
            session.save(studentObj);

            //commit transaction
            session.getTransaction().commit();

            //retrieving from db
            System.out.println("generated id: "+studentObj.getId());
            //get a new session, start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            //retrieve student based on primary key:id
            System.out.println("getting student: "+studentObj.getId());
            Student student = session.get(Student.class,studentObj.getId());
            System.out.println("get complete: "+student);
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
