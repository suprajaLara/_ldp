package org.example.mappings.manyToMany;

import org.example.mappings.manyToMany.entity.Student;
import org.example.mappings.manyToMany.entity.Course;
import org.example.mappings.manyToMany.entity.Instructor;
import org.example.mappings.manyToMany.entity.InstructorDetail;
import org.example.mappings.manyToMany.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        //create session factory
        //for Configuration, check import statements, there are two, select appropriate one.
        SessionFactory factory = new Configuration()
                                    .configure("hibernate_forManyToManyMapping.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        //this code (for Configuration) worked when jaxb api dependency is added to pom.xml

        //create session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

            //create a course
            Course course = new Course("Karate");

            // save the course
            System.out.println("\nSaving the course..");
            session.save(course);
            System.out.println("Saved the course: "+course);

            //create the students
            Student student1 = new Student("Manga", "Reader","manga@mail.com");
            Student student2 = new Student("John", "Modi","naren@mail.com");

            //add students to the course
            course.addStudent(student1);
            course.addStudent(student2);

            //save the students
            System.out.println("\nSaving the students..");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved the student: "+student1);
            System.out.println("Saved the student: "+student2);

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
