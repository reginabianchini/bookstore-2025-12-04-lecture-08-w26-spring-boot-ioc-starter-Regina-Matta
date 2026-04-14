package csd214.app.repositories;
import csd214.app.entities.ProductEntity;
import jakarta.persistence.*;
import java.util.List;

public abstract class JpaRepository implements IRepository<ProductEntity> {
    protected EntityManagerFactory emf;
    protected EntityManager em;
    private String name;

    public JpaRepository(String puName, String displayName) {
        this.emf = Persistence.createEntityManagerFactory(puName);
        this.em = emf.createEntityManager();
        this.name = displayName;
    }

    @Override public ProductEntity save(ProductEntity entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (entity.getId() == null) em.persist(entity);
            else entity = em.merge(entity);
            tx.commit();
            return entity;
        } catch (Exception e) { if (tx.isActive()) tx.rollback(); throw e; }
    }

    @Override public List<ProductEntity> findAll() { return em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class).getResultList(); }
    @Override public ProductEntity findById(Long id) { return em.find(ProductEntity.class, id); }
    @Override public void delete(Long id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ProductEntity p = findById(id);
        if (p != null) em.remove(p);
        tx.commit();
    }
    @Override public long count() { return em.createQuery("SELECT COUNT(p) FROM ProductEntity p", Long.class).getSingleResult(); }
    @Override public int deleteAll() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        int deleted = em.createQuery("DELETE FROM ProductEntity").executeUpdate();
        tx.commit();
        return deleted;
    }
    @Override public String getDataSourceType() { return "JPA DATABASE: " + name; }
    @Override public void close() { em.close(); emf.close(); }
}