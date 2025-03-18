package com.upendra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        Student s1=new Student();
//        s1.setRollNo(6);
//        s1.setName("sumith");
//        s1.setAge(21);



//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(com.upendra.Student.class);
//        cfg.configure();
//        SessionFactory sf=cfg.buildSessionFactory();
//

        SessionFactory sf=new Configuration()
                .addAnnotatedClass(com.upendra.Student.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
//        Transaction transaction=session.beginTransaction();
//
//        session.persist(s1);
//        transaction.commit();  no need for the second object

        s1=session.get(Student.class,6);
        Transaction transaction=session.beginTransaction();

        //session.merge(s1);
        session.remove(s1);
        transaction.commit();


        session.close();
        sf.close();
        System.out.println(s1);

    }
}