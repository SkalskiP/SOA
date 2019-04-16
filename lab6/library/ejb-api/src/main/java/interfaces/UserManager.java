package interfaces;

import dto.UserDTO;

import java.util.List;

public interface UserManager {
    List<UserDTO> getUsers();
    UserDTO getUserById(Integer userId);
    void addUser(UserDTO user);
    void removeUser(UserDTO user);
    void modifyUser(UserDTO user);
}
