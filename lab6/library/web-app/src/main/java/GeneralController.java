import dto.BorrowDTO;
import interfaces.remote.RemoteBookManager;
import interfaces.remote.RemoteBorrowManager;
import interfaces.remote.RemoteUserManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("GeneralController")
@SessionScoped
public class GeneralController implements Serializable {

    @EJB(lookup = "java:global/ejb-implementation-1.0/BorrowManagerBean!interfaces.remote.RemoteBorrowManager")
    private RemoteBorrowManager borrowsManager;
    @EJB(lookup = "java:global/ejb-implementation-1.0/UserManagerBean!interfaces.remote.RemoteUserManager")
    private RemoteUserManager userManager;
    @EJB(lookup = "java:global/ejb-implementation-1.0/BookManagerBean!interfaces.remote.RemoteBookManager")
    private RemoteBookManager bookManager;

    private Integer selectedUserId = null;
    private Boolean isAdminModeActive = true;

    private ArrayList<String> adminButtons = new ArrayList<String>() {{
        add("Manage users");
        add("Manage books");
        add("Manage borrows");
    }};

    private ArrayList<String> userButtons = new ArrayList<String>() {{
        add("Borrow new");
        add("Your books");
        add("Penalties");
    }};

    private String currentAdminSelection = "Manage users";
    private String currentUserSelection = "Borrow new";

    public Integer getSelectedUserId() {
        return selectedUserId;
    }

    public List<BorrowDTO> getSelectedUserBorrows() {
        return borrowsManager.getBorrowsForUser(selectedUserId);
    }

    public void addBorrowForSelectedUser(Integer selectedBookId) {
        BorrowDTO borrowToBeAdded = new BorrowDTO(bookManager.getBookById(selectedBookId), userManager.getUserById(selectedUserId));
        borrowsManager.addBorrow(borrowToBeAdded);
    }

    public void setSelectedUserId(Integer selectedUserId) {
        this.selectedUserId = selectedUserId;
        System.out.println("Selected user id: " + selectedUserId.toString());
    }

    public void handleChangeUser() {
        if (selectedUserId != null) {
            System.out.println("New selected user: " + selectedUserId.toString());
        }
    }

    public Boolean getAdminModeActive() {
        return isAdminModeActive;
    }

    public void toggleAdminMode() {
        isAdminModeActive = !isAdminModeActive;
        System.out.println("Current admin mode: " + isAdminModeActive.toString());
        if (!isAdminModeActive) {
            selectedUserId = null;
        }
    }

    public ArrayList<String> getButtons() {
        if (isAdminModeActive) {
            return adminButtons;
        } else {
            return userButtons;
        }
    }

    public String getCurrentSelection() {
        if (isAdminModeActive) {
            return currentAdminSelection;
        } else {
            return currentUserSelection;
        }
    }

    public void handleSelection(String selectedButtonLabel) {
        if (isAdminModeActive) {
            currentAdminSelection = selectedButtonLabel;
        } else {
            currentUserSelection = selectedButtonLabel;
        }
        System.out.println("Current selection: " + selectedButtonLabel);
    }
}
