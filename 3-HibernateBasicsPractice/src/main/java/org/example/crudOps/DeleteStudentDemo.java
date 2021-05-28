package org.example.crudOps;

import org.example.crudOps.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class DeleteStudentDemo {
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

            //delete a student
//            System.out.println("deleting student "+studentId);
//            session.delete(student);

            //second way of deleting
            System.out.println("deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
