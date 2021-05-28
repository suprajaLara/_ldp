package org.example.mappings.oneToMany.uni;

import org.example.mappings.oneToMany.uni.entity.Course;
import org.example.mappings.oneToMany.uni.entity.Instructor;
import org.example.mappings.oneToMany.uni.entity.InstructorDetail;
import org.example.mappings.oneToMany.uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        //create session factory
        //for Configuration, check import statements, there are two, select appropriate one.
        SessionFactory factory = new Configuration()
                                    .configure("hibernate_forOneToManyMappingUni.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();
        //this code (for Configuration) worked when jaxb api dependency is added to pom.xml

        //create session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            // get the course
            int id=10;
            Course course = session.get(Course.class,id);

            //print the course
            System.out.println("Getting the Course: "+course);

            //print the course reviews
            System.out.println("Getting the reviews: "+course.getReviews());

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
