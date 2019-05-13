package dao;

import dto.AbstractDTO;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDAO<T extends AbstractDTO> {
    private static final String PERSISTENCE_UNIT_NAME = "NetfixUnit";
    private String className;
    private Class clazz;

    protected EntityManager entityManager;

    protected AbstractDAO(Class clazz) {
        this.clazz = clazz;
        className = clazz.getSimpleName();
        entityManager = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public List<T> getItems() {
        TypedQuery query = entityManager.createQuery("SELECT data FROM " + className + " data", clazz);
        return query.getResultList();
    }

    public T getItem(Integer itemId) {
        TypedQuery query = entityManager.createQuery("SELECT c FROM " + className + " c WHERE c.id = :id", clazz);
        query.setParameter("id", itemId);
        return (T) query.getSingleResult();
    }

    public void addItem(T item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateItem(T item) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.merge(item);
        entityManager.getTransaction().commit();
    }

    public void deleteItem(T item) {
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
        entityManager.getTransaction().commit();
    }

    public void deleteItem(Integer itemId) {
        T item = getItem(itemId);
        deleteItem(item);
    }
}