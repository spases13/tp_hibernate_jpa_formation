package fr.norsys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Create and save an example entity
        Employe entity = new Employe();
        entity.setName("Example");
        session.save(entity);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
