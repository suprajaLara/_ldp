package org.example.mappings.oneToMany.uni;

import org.example.mappings.oneToMany.uni.entity.Course;
import org.example.mappings.oneToMany.uni.entity.Instructor;
import org.example.mappings.oneToMany.uni.entity.InstructorDetail;
import org.example.mappings.oneToMany.uni.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class CreateCourseAndReviewsDemo {
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

            //create a course
            Course course = new Course("Pacman");

            //add some reviews
            course.addReview(new Review("Good course..!"));
            course.addReview(new Review("Worth it..!"));
            course.addReview(new Review("Don't choose this."));

            //save course and leverage the cascade all
            System.out.println("Saving the course (and it saves all reviews automatically..!)");
            System.out.println(course);
            System.out.println(course.getReviews());

            session.save(course);

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
