package beans;

import dao.BookDAO;
import dto.BookDTO;
import interfaces.remote.RemoteBookManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(RemoteBookManager.class)
public class BookManagerBean implements RemoteBookManager {

    @Override
    public List<BookDTO> getBooks() {
        return BookDAO.getInstance().getItems();
    }

    @Override
    public BookDTO getBookById(Integer bookId) {
        return BookDAO.getInstance().getItem(bookId);
    }

    @Override
    public void addBook(BookDTO book) {
        BookDAO.getInstance().createItem(book);
    }

    @Override
    public void removeBook(BookDTO book) {
        BookDAO.getInstance().deleteItem(book);
    }

    @Override
    public void modifyBook(BookDTO book) {
        BookDAO.getInstance().updateItem(book);
    }
}
