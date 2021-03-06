package beans;

import dao.UserDAO;
import dto.UserDTO;
import interfaces.remote.RemoteUserManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Remote(RemoteUserManager.class)
public class UserManagerBean implements RemoteUserManager {

    @Override
    public List<UserDTO> getUsers() {
        return UserDAO.getInstance().getItems();
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return UserDAO.getInstance().getItem(userId);
    }

    @Override
    public void addUser(UserDTO user) {
        UserDAO.getInstance().createItem(user);
    }

    @Override
    public void removeUser(UserDTO user) {
        UserDAO.getInstance().deleteItem(user);
    }

    @Override
    public void modifyUser(UserDTO user) {
        UserDAO.getInstance().updateItem(user);
    }
}
