package edu.upc.swarch.jpa;

import edu.upc.swarch.jpa.entities.Author;
import edu.upc.swarch.jpa.entities.Film;
import org.w3c.dom.stylesheets.LinkStyle;

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

    public void store(Film f) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.persist(f);
        em.close();
    }

    public void store(Author a) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.persist(a);
        em.close();
    }

    public List<Film> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            // We could use SQL, JPQL makes our life easier
            return em.createQuery("SELECT f FROM Film f ORDER BY year ASC", Film.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Film> findByYearRange(int from, int to) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            // We could use SQL, JPQL makes our life easier
            TypedQuery<Film> query = em.createQuery(
                    "SELECT f FROM Film f WHERE f.year >= :yfrom AND f.year <= :yto", Film.class);
            query.setParameter("yfrom", from);
            query.setParameter("yto", to);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
