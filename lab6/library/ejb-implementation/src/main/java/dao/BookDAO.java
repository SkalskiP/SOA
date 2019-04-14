package dao;

import dto.BookDTO;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class BookDAO {
    private static BookDAO instance;

    private EntityManager entityManager;

    private BookDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public static BookDAO getInstance() {
        if (instance == null) {
            instance = new BookDAO();
        }
        return instance;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<BookDTO> getItems() {
        Query query = entityManager.createQuery("FROM BookDTO", BookDTO.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public BookDTO getItem(Integer itemId) {
        BookDTO book = entityManager.find(BookDTO.class, itemId);
        if (book == null) {
            throw new EntityNotFoundException("Can't find Book for ID " + itemId);
        }
        return book;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateItem(BookDTO item) {
        entityManager.getTransaction().begin();
        entityManager.merge(item);
        entityManager.getTransaction().commit();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Optional<Integer> createItem(BookDTO item) {
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

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteItem(BookDTO item) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
        entityManager.getTransaction().commit();
    }
}
