import dto.BorrowDTO;
import interfaces.remote.RemoteBorrowManager;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("BorrowsController")
@RequestScoped
public class BorrowsController {
    @EJB(lookup = "java:global/ejb-implementation-1.0/BorrowManagerBean!interfaces.remote.RemoteBorrowManager")
    private RemoteBorrowManager borrowsManager;

    public List<BorrowDTO> getBorrows() {
        return borrowsManager.getAllBorrows();
    }

    public void deleteBorrow(Integer bookId) {
        borrowsManager.removeBorrow(borrowsManager.getBorrowById(bookId));
    }
}
