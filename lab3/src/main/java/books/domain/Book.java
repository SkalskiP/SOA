package books.domain;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String category;
    private double price;
    private String currency;
    private String pages;
    private String publisher;
    private String image;

    public Book() {}

    public Book(Integer id, String title, String author, String category, double price, String currency, String pages, String publisher, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.currency = currency;
        this.pages = pages;
        this.publisher = publisher;
        this.image = image;
    }

    public Book copy() {
        return new Book(this.id, this.title, this.author, this.category, this.price, this.currency, this.pages, this.publisher, this.image);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return this.author + " " + this.title + " " + this.category + " " + this.price;
    }
}
