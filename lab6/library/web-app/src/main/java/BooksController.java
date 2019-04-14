import dto.BookDTO;
import interfaces.remote.RemoteBookManager;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("BooksController")
@RequestScoped
public class BooksController implements Serializable {
    @EJB(lookup = "java:global/ejb-implementation-1.0/BookManagerBean!interfaces.remote.RemoteBookManager")
    private RemoteBookManager bookManager;

    public List<BookDTO> getBooks() {
        return bookManager.getBooks();
    }

    public void deleteBook(Integer bookId) {
        System.out.println("Hello controller");
        bookManager.removeBook(bookManager.getBookById(bookId));
    }
}
