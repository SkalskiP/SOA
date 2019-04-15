package beans;

import interfaces.remote.RemoteMenuManager;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@Remote(RemoteMenuManager.class)
public class MenuManagerBean implements RemoteMenuManager {

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

    @Override
    public void toggleAdminMode() {
        isAdminModeActive = !isAdminModeActive;
    }

    @Override
    public Boolean isAdminModeActive() {
        return isAdminModeActive;
    }

    @Override
    public ArrayList<String> getButtonLabelsForCurrentMode() {
        if (isAdminModeActive) {
            return adminButtons;
        } else {
            return userButtons;
        }
    }

    @Override
    public String getSelectedButtonLabel() {
        if (isAdminModeActive) {
            return currentAdminSelection;
        } else {
            return currentUserSelection;
        }
    }

    @Override
    public void setSelectedButtonLabel(String selectedButtonLabel) {
        if (isAdminModeActive) {
            currentAdminSelection = selectedButtonLabel;
        } else {
            currentUserSelection = selectedButtonLabel;
        }
    }
}