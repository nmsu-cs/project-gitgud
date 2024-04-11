package Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

import User.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewUserController {
    @FXML
    private TextField aggieIDTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private CheckBox yesCheckBox;

    @FXML
    private CheckBox noCheckBox;

    @FXML
    private Button enterButton;

    // Instance variables to store checkbox states
    private boolean isYesSelected = false;
    private boolean isNoSelected = false;
    private Map<String, User> userDatabase = new HashMap<>();

    @FXML
    private void initialize() {
        // Load existing user data from file (if any)
        User.loadUserData(userDatabase);

        // Add event handlers to CheckBoxes
        yesCheckBox.setOnAction(event -> {
            isYesSelected = yesCheckBox.isSelected();
            if (isYesSelected) {
                isNoSelected = false;
                noCheckBox.setSelected(false);
            }
        });

        noCheckBox.setOnAction(event -> {
            isNoSelected = noCheckBox.isSelected();
            if (isNoSelected) {
                isYesSelected = false;
                yesCheckBox.setSelected(false);
            }
        });
    }

    @FXML
    private void enterPressed(ActionEvent event) {
        String aggieID = aggieIDTextField.getText().trim();
        String firstName = firstNameTextField.getText().trim();
        String lastName = lastNameTextField.getText().trim();
    
        // Check if parking permit selection is made
        if (!isYesSelected && !isNoSelected) {
            System.out.println("Please select yes or no for the parking permit question.");
            return; // Stop further processing
        }
    
        // Check if Aggie ID, first name, and last name are provided
        if (aggieID.isBlank() || firstName.isBlank() || lastName.isBlank()) {
            System.out.println("Please enter Aggie ID, first name, and last name.");
            return; // Stop further processing
        }

        if (!aggieID.matches("\\d{9}")) {
            System.out.println("Invalid input. Aggie ID must be 9 digits long. Please try again.");
            return;
        } else if (userDatabase.containsKey(aggieID)) {
            User existingUser = userDatabase.get(aggieID);
            System.out.println("User with this Aggie ID is already been registered:");
            return;
        }
        // Create a string to represent the parking permit status
        String parkingPermitStatus = isYesSelected ? "Yes" : "No";
    }

    @FXML
    /**
     * This takes the user back to the Main menu when the back button is pushed.
     * @param event
     */
    private void backButtonPressed(ActionEvent event){
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml")); //loads the FXML file for the new window 
            Scene newScene = new Scene(root, 600, 400); //create a new scene size 600, 400
            stage.setScene(newScene); //set the scene to the stage
            stage.setTitle("New User Window"); //sets the title of the new window 
            stage.show(); //show the new window 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end newUserButtonPressed method
}
