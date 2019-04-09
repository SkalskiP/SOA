package books.beans;

import books.dao.BookDAO;
import books.dto.BookDTO;

import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="books")
@SessionScoped
public class BooksManager {

    private String title;
    private String authorName;
    private String authorSurname;
    private String publisher;
    private String isbn;
    private String category;
    private Integer pages;
    private Double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void clearFields() {
        this.title = null;
        this.authorName = null;
        this.authorSurname = null;
        this.publisher = null;
        this.isbn = null;
        this.category = null;
        this.pages = null;
        this.price = null;
    }

    public List<BookDTO> getBooksToDisplay() {
        return BookDAO.getInstance().getItems();
    }

    public void delete(Integer itemId) {
        BookDAO.getInstance().deleteItem(BookDAO.getInstance().getItem(itemId));
    }

    public void create() {
        Integer newId = BookDAO.getInstance().createItem(this.title, this.authorName, this.authorSurname, this.publisher, this.isbn, this.category, this.pages, this.price);
        System.out.println(newId);
        this.clearFields();
    }
}
