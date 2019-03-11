package edu.upc.swarch.jpa;

import edu.upc.swarch.jpa.entities.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class FilmsDAO {

    private EntityManagerFactory entityManagerFactory;

    public FilmsDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
    }

    // Stores a JPA object and commits the transaction
    public void store(Object f) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
    }

    public List<Film> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            // We could use SQL, but JPQL makes our life easier
            return em.createQuery("SELECT f FROM Film f ORDER BY year ASC", Film.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Film> findByYearRange(int from, int to) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            // We could use SQL, but JPQL makes our life easier
            TypedQuery<Film> query = em.createQuery(
                    "SELECT f FROM Film f WHERE f.year >= :year_from AND f.year <= :year_to", Film.class);
            query.setParameter("year_to", to);
            query.setParameter("year_from", from);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
