package books.dao;

import books.dto.BookDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BookDAO {
    private static BookDAO instance;

    private EntityManager entityManager;

    private BookDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BooksPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    public static BookDAO getInstance() {
        if (instance == null) {
            instance = new BookDAO();
        }
        return instance;
    }

    public List<BookDTO> getItems() {
        Query query = entityManager.createQuery("FROM BookDTO", BookDTO.class);
        return query.getResultList();
    }

    public BookDTO getItem(Integer itemId) {
        Query query = entityManager.createQuery("FROM BookDTO WHERE BookDTO.id = :id");
        query.setParameter("id", itemId);
        return (BookDTO) query.getSingleResult();
    }

    public void updateItem(BookDTO item) {
        entityManager.merge(item);
        entityManager.getTransaction().commit();
    }

    public void deleteItem(BookDTO item) {
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
        entityManager.getTransaction().commit();
    }

    public void deleteItem(Integer itemId) {
        BookDTO item = getItem(itemId);
        deleteItem(item);
    }
}
