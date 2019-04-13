package dao;

import dto.UserDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    private static UserDAO instance;

    private EntityManager entityManager;

    private UserDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public List<UserDTO> getItems() {
        Query query = entityManager.createQuery("FROM UserDTO", UserDTO.class);
        return query.getResultList();
    }

    public UserDTO getItem(Integer itemId) {
        UserDTO book = entityManager.find(UserDTO.class, itemId);
        if (book == null) {
            throw new EntityNotFoundException("Can't find User for ID " + itemId);
        }
        return book;
    }

    public void updateItem(UserDTO item) {
        entityManager.getTransaction().begin();
        entityManager.merge(item);
        entityManager.getTransaction().commit();
    }

    public Optional<Integer> createItem(UserDTO item) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(item);
            entityManager.getTransaction().commit();
            return Optional.of(item.getId());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return Optional.empty();
        }
    }

    public void deleteItem(UserDTO item) {
        entityManager.getTransaction().begin();
        entityManager.remove(item);
        entityManager.getTransaction().commit();
    }
}
