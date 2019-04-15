package beans;

import dao.BorrowDAO;
import dto.BorrowDTO;
import dto.UserDTO;
import interfaces.remote.RemoteBorrowManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
@Remote(RemoteBorrowManager.class)
public class BorrowManagerBean implements RemoteBorrowManager {

    @Override
    public List<BorrowDTO> getAllBorrows() {
        return BorrowDAO.getInstance().getItems();
    }

    @Override
    public List<BorrowDTO> getBorrowsForUser(UserDTO user) {
        return null;
    }

    @Override
    public BorrowDTO getBorrowById(Integer borrowId) {
        return BorrowDAO.getInstance().getItem(borrowId);
    }

    @Override
    public Optional<Integer> addBorrow(BorrowDTO borrow) {
        return Optional.empty();
    }

    @Override
    public void removeBorrow(BorrowDTO borrow) {
        BorrowDAO.getInstance().deleteItem(borrow);
    }

    @Override
    public void modifyBorrow(BorrowDTO borrow) {

    }
}
