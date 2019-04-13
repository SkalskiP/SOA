package interfaces;

import dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserManager {
    List<UserDTO> getUsers();
    UserDTO getUserById(Integer userId);
    Optional<Integer> addUser(UserDTO user);
    void removeUser(UserDTO user);
    void modifyUser(UserDTO user);
}
