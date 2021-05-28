package org.example.mappings.oneToOne.uni;

import org.example.mappings.oneToOne.uni.entity.Instructor;
import org.example.mappings.oneToOne.uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        //create session factory
        //for Configuration, check import statements, there are two, select appropriate one.
        SessionFactory factory = new Configuration()
                                    .configure("hibernate_forOneToOneMapping.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();
        //this code (for Configuration) worked when jaxb api dependency is added to pom.xml

        //create session
        Session session = factory.getCurrentSession();

        try{

            //start a transaction
            session.beginTransaction();

            //get instructor by primary key id
            int id = 1;
            Instructor instructor = session.get(Instructor.class,id);
            System.out.println("Found instructor: "+instructor);

            //delete instructors
            if (instructor!=null){
                System.out.println("deleting: "+instructor);
                //this will ALSO delete associated "details" object, because of CascadeType.ALL
                session.delete(instructor);
            }

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
