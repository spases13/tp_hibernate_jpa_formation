package dao;

import model.Avion;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AvionDAO {
    public Avion findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Avion.class, id);
        }
    }
}