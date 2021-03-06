package beans;

import dao.BorrowDAO;
import dto.BorrowDTO;
import interfaces.remote.RemoteBorrowManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(RemoteBorrowManager.class)
public class BorrowManagerBean implements RemoteBorrowManager {

    @Override
    public List<BorrowDTO> getAllBorrows() {
        return BorrowDAO.getInstance().getItems();
    }

    @Override
    public List<BorrowDTO> getBorrowsForUser(Integer userId) {
        return BorrowDAO.getInstance().getAllBorrowsByUser(userId);
    }

    @Override
    public BorrowDTO getBorrowById(Integer borrowId) {
        return BorrowDAO.getInstance().getItem(borrowId);
    }

    @Override
    public void addBorrow(BorrowDTO borrow) {
        BorrowDAO.getInstance().createItem(borrow);
    }

    @Override
    public void removeBorrow(BorrowDTO borrow) {
        BorrowDAO.getInstance().deleteItem(borrow);
    }

    @Override
    public void modifyBorrow(BorrowDTO borrow) {

    }
}
