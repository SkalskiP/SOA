package interfaces;

import java.util.ArrayList;

public interface MenuManager {
    void toggleAdminMode();
    Boolean isAdminModeActive();
    ArrayList<String> getButtonLabelsForCurrentMode();
    String getSelectedButtonLabel();
    void setSelectedButtonLabel(String selectedButtonLabel);
}
