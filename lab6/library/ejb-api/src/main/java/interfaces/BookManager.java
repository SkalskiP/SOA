package interfaces;

import dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookManager {
    List<BookDTO> getBooks();
    BookDTO getBookById(Integer bookId);
    Optional<Integer> addBook(BookDTO book);
    void removeBook(BookDTO book);
    void modifyBook(BookDTO book);
}
