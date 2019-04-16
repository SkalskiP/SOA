import dto.BookDTO;
import interfaces.remote.RemoteBookManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("BooksController")
@SessionScoped
public class BooksController implements Serializable {
    @EJB(lookup = "java:global/ejb-implementation-1.0/BookManagerBean!interfaces.remote.RemoteBookManager")
    private RemoteBookManager bookManager;
    private BookDTO bookDataHolder;

    public BooksController() {
        bookDataHolder = new BookDTO();
    }

    public List<BookDTO> getBooks() {
        return bookManager.getBooks();
    }

    public void deleteBook(Integer bookId) {
        bookManager.removeBook(bookManager.getBookById(bookId));
    }

    public BookDTO getBookDataHolder() {
        return bookDataHolder;
    }

    public void setBookDataHolder(BookDTO bookDataHolder) {
        this.bookDataHolder = bookDataHolder;
    }

    public void addBook() {
        bookManager.addBook(bookDataHolder);
        bookDataHolder = new BookDTO();
    }
}
