package org.example.mappings.oneToMany.bi;

import org.example.mappings.oneToMany.bi.entity.Course;
import org.example.mappings.oneToMany.bi.entity.Instructor;
import org.example.mappings.oneToMany.bi.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class DeleteCourseDemo {
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

            //get a course
            int id = 10;
            Course course = session.get(Course.class,id);

            //delete course
            System.out.println("deleting course: "+course);
            session.delete(course);

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
