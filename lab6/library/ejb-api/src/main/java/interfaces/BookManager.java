package interfaces;

import dto.BookDTO;

import java.util.List;

public interface BookManager {
    List<BookDTO> getBooks();
    BookDTO getBookById(Integer bookId);
    void addBook(BookDTO book);
    void removeBook(BookDTO book);
    void modifyBook(BookDTO book);
}
