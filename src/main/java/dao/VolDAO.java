package dao;

import model.Vol;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VolDAO {
    public Vol findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Vol.class, id);
        }
    }
}