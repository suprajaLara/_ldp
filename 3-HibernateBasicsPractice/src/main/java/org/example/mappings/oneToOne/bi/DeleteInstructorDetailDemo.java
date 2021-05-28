package org.example.mappings.oneToOne.bi;

import org.example.mappings.oneToOne.bi.entity.Instructor;
import org.example.mappings.oneToOne.bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class DeleteInstructorDetailDemo {
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

            //get instructor detail object
            int id = 3;
            InstructorDetail instructorDetail =
                    session.get(InstructorDetail.class,id);

            //print instructor detail
            System.out.println("Instructor detail: "+instructorDetail);

            //print associated instructor
            System.out.println("Associated instructor: "+instructorDetail.getInstructor());

            // delete instructor detail
            System.out.println("deleting instructor detail obj: "+instructorDetail);

            //remove the associated object reference, to be able to delete only the instructor detail obj
            //break bi-directional reference
            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
