package interfaces;

import dto.BorrowDTO;
import dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface BorrowManager {
    List<BorrowDTO> getAllBorrows();
    List<BorrowDTO> getBorrowsForUser(UserDTO user);
    BorrowDTO getBorrowById(Integer borrowId);
    Optional<Integer> addBorrow(BorrowDTO borrow);
    void removeBorrow(BorrowDTO borrow);
    void modifyBorrow(BorrowDTO borrow);
}
