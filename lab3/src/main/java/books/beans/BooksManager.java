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
    private ArrayList<Book> booksAll;
    private ArrayList<Book> booksToDisplay;
    private Map<Integer, Boolean> booksSelectionStatus = new HashMap<>();
    private Map<String, String> selectedFilters = new HashMap<>();
    private double totalPrice = 0;
    private int selectedBooksCount = 0;

    private Map<String, String> filtersLabels = new HashMap() {{
        put("title", "Title");
        put("author", "Author");
        put("category", "Category");
        put("priceMin", "Price Min");
        put("priceMax", "Price Max");

    }};

    public BooksManager() {
        this.booksAll = BookUtil.loadDataFromCsv(getClass().getClassLoader().getResource("assets/books.csv").getFile());
        this.booksToDisplay = new ArrayList<>(this.booksAll);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSelectedBooksCount() {
        return selectedBooksCount;
    }

    public void setSelectedBooksCount(int selectedBooksCount) {
        this.selectedBooksCount = selectedBooksCount;
    }

    public ArrayList<Book> getBooksToDisplay() {
        return booksToDisplay;
    }

    public void setBooksToDisplay(ArrayList<Book> booksToDisplay) {
        this.booksToDisplay = booksToDisplay;
    }

    public Map<Integer, Boolean> getBooksSelectionStatus() {
        return booksSelectionStatus;
    }

    public void setBooksSelectionStatus(Map<Integer, Boolean> booksSelectionStatus) {
        this.booksSelectionStatus = booksSelectionStatus;
    }

    public Map<String, String> getFiltersLabels() {
        return filtersLabels;
    }

    public void setFiltersLabels(Map<String, String> filtersLabels) {
        this.filtersLabels = filtersLabels;
    }

    public Map<String, String> getSelectedFilters() {
        return selectedFilters;
    }

    public void setSelectedFilters(Map<String, String> selectedFilters) {
        this.selectedFilters = selectedFilters;
    }

    public void filterData() {
        this.booksToDisplay = new ArrayList<>(this.booksAll);
        for (Map.Entry<String, String> entry: this.selectedFilters.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (!entry.getValue().isEmpty()) {
                switch (entry.getKey()) {
                    case "title":
                        this.booksToDisplay.removeIf(book -> !book.getTitle().toLowerCase().contains(entry.getValue().toLowerCase()));
                        break;
                    case "author":
                        this.booksToDisplay.removeIf(book -> !book.getAuthor().toLowerCase().contains(entry.getValue().toLowerCase()));
                        break;
                    case "category":
                        this.booksToDisplay.removeIf(book -> !book.getCategory().toLowerCase().contains(entry.getValue().toLowerCase()));
                        break;
                    case "priceMin":
                        this.booksToDisplay.removeIf(book -> book.getPrice() <= Double.parseDouble(entry.getValue()));
                        break;
                    case "priceMax":
                        this.booksToDisplay.removeIf(book -> book.getPrice() >= Double.parseDouble(entry.getValue()));
                        break;
                }
            }
        }
        BookUtil.reIndex(this.booksToDisplay);
    }

    public void checkoutSelected() {
        int checkedCounter = 0;
        for (Map.Entry<Integer, Boolean> entry: this.booksSelectionStatus.entrySet()) {
            if (entry.getValue()) {
                this.totalPrice += this.booksToDisplay.get(entry.getKey()).getPrice();
                checkedCounter++;
            }
        }
        this.totalPrice = Math.round(this.totalPrice * 100.0) / 100.0;
        this.selectedBooksCount = checkedCounter;
    }
}
