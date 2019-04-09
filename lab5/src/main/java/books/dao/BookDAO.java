package books.dao;

import books.dto.BookDTO;

import javax.persistence.*;
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
        BookDTO book = entityManager.find(BookDTO.class, itemId);
        if (book == null) {
            throw new EntityNotFoundException("Can't find Book for ID " + itemId);
        }
        return book;
    }

    public void updateItem(BookDTO item) {
        entityManager.merge(item);
        entityManager.getTransaction().commit();
    }

    public Integer createItem(String title, String authorName, String authorSurname, String publisher, String isbn, String category, Integer pages, Double price) {
        BookDTO book = new BookDTO();
        book.setTitle(title);
        book.setAuthorName(authorName);
        book.setAuthorSurname(authorSurname);
        book.setPublisher(publisher);
        book.setIsbn(isbn);
        book.setCategory(category);
        book.setPages(pages);
        book.setPrice(price);

        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        return book.getId();
    }

    public void deleteItem(BookDTO item) {
        entityManager.getTransaction().begin();
        entityManager.remove(item);
        entityManager.getTransaction().commit();
    }

    public void deleteItem(Integer itemId) {
        BookDTO item = getItem(itemId);
        deleteItem(item);
    }
}
