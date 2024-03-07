package dao;

import model.Pilote;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PiloteDAO {
    public Pilote findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Pilote.class, id);
        }
    }
}