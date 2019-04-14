import dto.UserDTO;
import interfaces.remote.RemoteUserManager;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("UsersController")
@RequestScoped
public class UsersController implements Serializable {

    @EJB(lookup = "java:global/ejb-implementation-1.0/UserManagerBean!interfaces.remote.RemoteUserManager")
    private RemoteUserManager userManager;

    public List<UserDTO> getUsers() {
        return userManager.getUsers();
    }

    public void deleteUser(Integer userId) {
        System.out.println("Hello controller");
        userManager.removeUser(userManager.getUserById(userId));
    }
}
