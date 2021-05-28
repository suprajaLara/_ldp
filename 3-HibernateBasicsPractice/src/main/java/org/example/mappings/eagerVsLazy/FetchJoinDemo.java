package org.example.mappings.eagerVsLazy;

import org.example.mappings.eagerVsLazy.entity.Course;
import org.example.mappings.eagerVsLazy.entity.Instructor;
import org.example.mappings.eagerVsLazy.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//import javax.security.auth.login.Configuration;

public class FetchJoinDemo {
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

            //option2: hibernate query with HQL

            //get instructor from db
            int id=1;

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id=:id",
                            Instructor.class);

            //set parameter on query
            query.setParameter("id",id);

            //execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("My code: instructor: "+instructor);

            //commit transaction
            session.getTransaction().commit();

            //close the session
            session.close();
            System.out.println("\nMy code: session is closed....\n");

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
