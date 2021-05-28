package org.example.mappings.oneToMany.bi;

import org.example.mappings.oneToMany.bi.entity.Course;
import org.example.mappings.oneToMany.bi.entity.Instructor;
import org.example.mappings.oneToMany.bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class CreateCoursesDemo {
    public static void main(String[] args) {
        //create session factory
        //for Configuration, check import statements, there are two, select appropriate one.
        SessionFactory factory = new Configuration()
                                    .configure("hibernate_forOneToManyMappingBi.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();
        //this code (for Configuration) worked when jaxb api dependency is added to pom.xml

        //create session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            //get instructor from db
            int id=1;
            Instructor instructor = session.get(Instructor.class,id);

            //create some courses
            Course course1 = new Course("Air guitar");
            Course course2 = new Course("Pin ball");

            //add courses to instructor
            instructor.add(course1);
            instructor.add(course2);

            //save the courses
            session.save(course1);
            session.save(course2);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            // add clean up
            session.close();
            factory.close();
        }
    }
}
