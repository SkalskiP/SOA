import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named("GeneralController")
@SessionScoped
public class GeneralController implements Serializable {

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
