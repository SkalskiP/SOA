package books.beans;

import books.domain.Book;
import books.utils.BookUtil;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;

@ManagedBean(name="books")
@ViewScoped
public class BooksManager {
    private ArrayList<Book> books;
    private Map<Integer, Boolean> checked = new HashMap<>();

    public BooksManager() {
        this.books = BookUtil.loadDataFromCsv(getClass().getClassLoader().getResource("assets/books.csv").getFile());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
        this.checked = checked;
    }
}
