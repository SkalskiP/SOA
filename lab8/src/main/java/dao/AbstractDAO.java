package dao;

import dto.AbstractDTO;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

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

    public Optional<Integer> addItem(T item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
            entityManager.refresh(item);
            return Optional.of(item.getId());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return Optional.empty();
        }
    }

    public T updateItem(T item) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.merge(item);
        entityManager.getTransaction().commit();
        entityManager.refresh(item);
        return item;
    }

    public void deleteItem(T item) {
        entityManager.getTransaction().begin();
        entityManager.remove(item);
        entityManager.getTransaction().commit();
    }

    public void deleteItem(Integer itemId) {
        T item = getItem(itemId);
        deleteItem(item);
    }
}