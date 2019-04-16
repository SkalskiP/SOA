import dto.UserDTO;
import interfaces.remote.RemoteUserManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("UsersController")
@SessionScoped
public class UsersController implements Serializable {
    @EJB(lookup = "java:global/ejb-implementation-1.0/UserManagerBean!interfaces.remote.RemoteUserManager")
    private RemoteUserManager userManager;
    private UserDTO userDataHolder;

    public UsersController() {
        userDataHolder = new UserDTO();
    }

    public List<UserDTO> getUsers() {
        return userManager.getUsers();
    }

    public void deleteUser(Integer userId) {
        userManager.removeUser(userManager.getUserById(userId));
    }

    public UserDTO getUserDataHolder() {
        return userDataHolder;
    }

    public void setUserDataHolder(UserDTO userDataHolder) {
        this.userDataHolder = userDataHolder;
    }

    public void addUser() {
        userManager.addUser(userDataHolder);
        userDataHolder = new UserDTO();
    }
}
