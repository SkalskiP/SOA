package dao;

import dto.BorrowDTO;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import java.util.List;

public class BorrowDAO {
    private static BorrowDAO instance;

    private EntityManager entityManager;

    private BorrowDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public static BorrowDAO getInstance() {
        if (instance == null) {
            instance = new BorrowDAO();
        }
        return instance;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<BorrowDTO> getItems() {
        Query query = entityManager.createQuery("FROM BorrowDTO", BorrowDTO.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public BorrowDTO getItem(Integer itemId) {
        BorrowDTO book = entityManager.find(BorrowDTO.class, itemId);
        if (book == null) {
            throw new EntityNotFoundException("Can't find Borrow for ID " + itemId);
        }
        return book;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteItem(BorrowDTO item) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
        entityManager.getTransaction().commit();
    }
}
