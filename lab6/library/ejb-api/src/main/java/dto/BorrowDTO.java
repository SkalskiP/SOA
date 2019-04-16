package dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity()
@Table(name = "borrows")
@Access(AccessType.FIELD)
public class BorrowDTO implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private BookDTO book;

    @OneToOne
    private UserDTO user;

    @Column(name = "borrow_start_date", nullable = false)
    private Date borrowStartDate;

    @Column(name = "borrow_end_date")
    private Date borrowEndDate;

    public BorrowDTO() {}

    public BorrowDTO(BookDTO book, UserDTO user) {
        this.book = book;
        this.user = user;
        this.borrowStartDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getBorrowStartDate() {
        return borrowStartDate;
    }

    public void setBorrowStartDate(Date borrowStartDate) {
        this.borrowStartDate = borrowStartDate;
    }

    public Date getBorrowEndDate() {
        return borrowEndDate;
    }

    public void setBorrowEndDate(Date borrowEndDate) {
        this.borrowEndDate = borrowEndDate;
    }
}
