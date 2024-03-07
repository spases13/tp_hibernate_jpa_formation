import javax.persistence.*;

import model.Vol;

import java.util.*;

public class Main {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("AvionUnit");

        try {
            findAllFlightsByPlane(1);
            findAllFlightsFromCity("Paris");
            findAllFlightsToCityBetweenTimes("New York", 10, 16);
            calculateTotalFlightsByPilot(1);
            findAllFlightsBetweenDates(new Date(2024, 3, 1), new Date(2024, 3, 10));
        } finally {
            entityManagerFactory.close();
        }
    }

    private static void findAllFlightsByPlane(int avionId) {	
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.avion.NA = :avionId", Vol.class);
        query.setParameter("avionId", avionId);
        List<Vol> flights = query.getResultList();

        for (Vol flight : flights) {
            System.out.println("Vol avec ID " + flight.getNV() + " effectué par l'avion avec ID " + avionId);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void findAllFlightsFromCity(String city) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.VD = :city", Vol.class);
        query.setParameter("city", city);
        List<Vol> flights = query.getResultList();

        for (Vol flight : flights) {
            System.out.println("Vol avec ID " + flight.getNV() + " partant de la ville " + city);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void findAllFlightsToCityBetweenTimes(String city, int startTime, int endTime) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.VA = :city AND v.HD >= :startTime AND v.HA <= :endTime", Vol.class);
        query.setParameter("city", city);
        query.setParameter("startTime", startTime);
        query.setParameter("endTime", endTime);
        List<Vol> flights = query.getResultList();

        for (Vol flight : flights) {
            System.out.println("Vol avec ID " + flight.getNV() + " arrivant à la ville " + city + " entre " + startTime + "h et " + endTime + "h");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void calculateTotalFlightsByPilot(int pilotId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(v) FROM Vol v WHERE v.pilote.NP = :pilotId", Long.class);
        query.setParameter("pilotId", pilotId);
        long totalFlights = query.getSingleResult();

        System.out.println("Nombre total de vols effectués par le pilote avec ID " + pilotId + " : " + totalFlights);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void findAllFlightsBetweenDates(Date startDate, Date endDate) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        TypedQuery<Vol> query = entityManager.createQuery("SELECT v FROM Vol v WHERE v.HD BETWEEN :startDate AND :endDate OR v.HA BETWEEN :startDate AND :endDate", Vol.class);
        query.setParameter("startDate", sqlStartDate);
        query.setParameter("endDate", sqlEndDate);
        List<Vol> flights = query.getResultList();

        for (Vol flight : flights) {
            System.out.println("Vol avec ID " + flight.getNV() + " effectué entre " + startDate + " et " + endDate);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
