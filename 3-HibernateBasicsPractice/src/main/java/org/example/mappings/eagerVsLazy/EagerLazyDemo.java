package org.example.mappings.eagerVsLazy;

import org.example.mappings.eagerVsLazy.entity.Course;
import org.example.mappings.eagerVsLazy.entity.Instructor;
import org.example.mappings.eagerVsLazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;

public class EagerLazyDemo {
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
            // In this case, Fetch property is set - (for instructor-courses mapping)
            //it fetches all details of instructor, instructorDetail, courses tables, if we use EAGER FETCH
            //it fetches only the details of instructor, instructorDetail tables, if we use LAZY FETCH
            Instructor instructor = session.get(Instructor.class,id);

            System.out.println("My code: instructor: "+instructor);

            // get course for instructor
            System.out.println("My code: courses: "+instructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            //close the session
            session.close();
            System.out.println("\nMy code: session is closed....\n");

            // get course for instructor
            //since courses are lazy loaded, this should fail (LazyInitializationException)
            //to solve this issue:
            // option1: call getter method while session is open -- shown in line 37
            // option2: querying with HQL -- shown in FetchJoinDemo file
            System.out.println("My code: courses: "+instructor.getCourses());

            System.out.println("My code: Done..!");
        }
        finally {
            // add clean up
            session.close();
            factory.close();
        }
    }
}
