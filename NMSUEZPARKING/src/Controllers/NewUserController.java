package Controllers;

import User.DataUserEntered;
import User.User;
//import User.UserDataLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

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

    DataUserEntered data = DataUserEntered.getInstance();

    // Instance variables to store checkbox states
    private boolean isYesSelected = false;
    private boolean isNoSelected = false;

    @FXML
    private void initialize() {
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
        }

        // If user selects "No" for parking permit, navigate to sample4nopermit.fxml
        if (isNoSelected) {
            try {
                Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample4nopermit.fxml"));
                Scene newScene = new Scene(root, 600, 400);
                stage.setScene(newScene);
                stage.setTitle("No Parking Permit");
                stage.show();
                return; // Stop further processing
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Create a new User object
        User newUser = new User(aggieID, firstName + " " + lastName, isYesSelected, "BLANK");

        // Add the new user to the user database
        //User.saveUserToFile(newUser, "project-gitgud/user_data.txt");
        data.setAggieID(aggieID);
        data.setFullName(newUser.getFullName());
        data.setHasParkingPermit(isYesSelected);
        data.setParkingPermitType("BLANK");


        // Optionally, you can provide feedback to the user that the registration was successful
        System.out.println("User registration successful!");

        // Clear input fields and checkboxes
        aggieIDTextField.clear();
        firstNameTextField.clear();
        lastNameTextField.clear();
        yesCheckBox.setSelected(false);
        noCheckBox.setSelected(false);

        // Loading new page so user can enter their parking permit type
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root;

            // Load the root depending on whether the user has the permit or not.
            if(isYesSelected) root = FXMLLoader.load(getClass().getResource("/FXML/sample5haspermit.fxml")); //loads has permit scene
            else root = FXMLLoader.load(getClass().getResource("/FXML/sample4nopermit.fxml")); // Load no permit scene

            Scene newScene = new Scene(root, 600, 400); //create a new scene size 600, 400
            stage.setScene(newScene); //set the scene to the stage
            stage.setTitle("New User Window"); //sets the title of the new window 
            stage.show(); //show the new window 
        } catch (Exception e) {
            e.printStackTrace();
        }
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
