import dto.BookDTO;
import dto.BorrowDTO;
import dto.UserDTO;
import interfaces.remote.RemoteBookManager;
import interfaces.remote.RemoteBorrowManager;
import interfaces.remote.RemoteUserManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("BorrowsController")
@SessionScoped
public class BorrowsController implements Serializable {
    @EJB(lookup = "java:global/ejb-implementation-1.0/BorrowManagerBean!interfaces.remote.RemoteBorrowManager")
    private RemoteBorrowManager borrowsManager;
    @EJB(lookup = "java:global/ejb-implementation-1.0/UserManagerBean!interfaces.remote.RemoteUserManager")
    private RemoteUserManager userManager;
    @EJB(lookup = "java:global/ejb-implementation-1.0/BookManagerBean!interfaces.remote.RemoteBookManager")
    private RemoteBookManager bookManager;
    private Integer selectedBookId;
    private Integer selectedUserId;

    public BorrowsController() {
        selectedBookId = null;
        selectedUserId = null;
    }

    public List<BorrowDTO> getBorrows() {
        return borrowsManager.getAllBorrows();
    }

    public Integer getSelectedBookId() {
        return selectedBookId;
    }

    public void setSelectedBookId(Integer selectedBookId) {
        this.selectedBookId = selectedBookId;
    }

    public Integer getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(Integer selectedUserId) {
        this.selectedUserId = selectedUserId;
    }

    public void deleteBorrow(Integer bookId) {
        borrowsManager.removeBorrow(borrowsManager.getBorrowById(bookId));
    }

    public void addBorrow() {
        System.out.println("BorrowsController.addBorrow");
        System.out.println(selectedBookId);
        System.out.println(selectedUserId);
        BorrowDTO borrowToBeAdded = new BorrowDTO(bookManager.getBookById(selectedBookId), userManager.getUserById(selectedUserId));
        borrowsManager.addBorrow(borrowToBeAdded);
        selectedBookId = null;
        selectedUserId = null;
    }
}
