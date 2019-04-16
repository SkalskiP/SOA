package dao;

import dto.UserDTO;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import java.util.List;

public class UserDAO {
    private static UserDAO instance;

    private EntityManager entityManager;

    private UserDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<UserDTO> getItems() {
        Query query = entityManager.createQuery("FROM UserDTO", UserDTO.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public UserDTO getItem(Integer itemId) {
        UserDTO book = entityManager.find(UserDTO.class, itemId);
        if (book == null) {
            throw new EntityNotFoundException("Can't find User for ID " + itemId);
        }
        return book;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateItem(UserDTO item) {
        entityManager.getTransaction().begin();
        entityManager.merge(item);
        entityManager.getTransaction().commit();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createItem(UserDTO item) {
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteItem(UserDTO item) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
        entityManager.getTransaction().commit();
    }
}
