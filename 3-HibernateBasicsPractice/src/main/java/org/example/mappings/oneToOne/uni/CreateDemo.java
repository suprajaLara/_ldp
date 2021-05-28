package org.example.mappings.oneToOne.uni;

import org.example.mappings.oneToOne.uni.entity.Instructor;
import org.example.mappings.oneToOne.uni.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class CreateDemo {
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
            //create the objects
            Instructor instructor =
                    new Instructor("Madhu","dary", "hellomadhu@mail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail(
                            "http://www.madhu.com/youtube",
                            "everything is madhu hobby");

            //associate the objects
            instructor.setInstructorDetail(instructorDetail);

            //start a transaction
            session.beginTransaction();

           //save the instructor
           // ** This will ALSO save the derails object, because of CascadeType.ALL
            System.out.println("saving instructor: "+instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
