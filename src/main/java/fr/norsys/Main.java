package fr.norsys;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        //begin transaction
        transaction.begin();
        Employe employe = new Employe();
        employe.setName("John Doe");
        //use persist
        entityManager.persist(employe);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
