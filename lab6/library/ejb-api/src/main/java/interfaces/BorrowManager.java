package interfaces;

import dto.BorrowDTO;
import dto.UserDTO;

import java.util.List;

public interface BorrowManager {
    List<BorrowDTO> getAllBorrows();
    List<BorrowDTO> getBorrowsForUser(UserDTO user);
    BorrowDTO getBorrowById(Integer borrowId);
    void addBorrow(BorrowDTO borrow);
    void removeBorrow(BorrowDTO borrow);
    void modifyBorrow(BorrowDTO borrow);
}
