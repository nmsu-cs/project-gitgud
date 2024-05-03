package Controllers;

import java.util.HashMap;
import java.util.Map;

import User.DataUserEntered;
import User.User;
//import User.UserDataLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPageController {
    
    //login button takes user into new window to answer questions
    @FXML
    private Button homeButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField aggieIDTextField;

    @FXML
    private Button exitButton;

    private Map<String, User> userDatabase = new HashMap<>();

    DataUserEntered data = DataUserEntered.getInstance();

    @FXML
    private void initialize() {
        // Load existing user data from file (if any)
        User.loadUserData(userDatabase);
    }

    @FXML
    public void homeButtonPressed(ActionEvent event){
        String fullName = fullNameTextField.getText().trim();
        String aggieID = aggieIDTextField.getText().trim();

        if(fullName.isBlank() || aggieID.isBlank()){
            System.out.println("Please enter your full name and aggie ID.");
            return;
        }

        // Iterate through the hash map of the user data
        for(Map.Entry<String, User> entry : userDatabase.entrySet()){
            String dataBaseAggieID = entry.getKey();
            User user = entry.getValue();

            // Check if both aggie id and full name are equal to an entry in the data, then load next page.
            if(aggieID.equals(dataBaseAggieID) && fullName.equals(user.getFullName())){
                data.setAggieID(user.getAggieID());
                data.setFullName(user.getFullName());
                data.setHasParkingPermit(user.getHasParkingPermit());
                data.setParkingPermitType(user.getParkingPermitType());
                try{
                    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample2.fxml"));
                    Scene secondaryScene = new Scene(root, 600, 400);
                    stage.setScene(secondaryScene);
                    stage.setTitle("Welcome back");
                    
                    //show the new scene 
                    stage.show();

                    //Exit the method after successsfully finding the user
                    return;

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        
        System.out.println("Could not find matching user. Please try again.");
    }//end homeButtonPressed method 

    //new user button take user into new window to answer a different set of questions
    @FXML
    private void newUserButtonPressed(ActionEvent event) {

        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample3.fxml")); //loads the FXML file for the new window 
            Scene newScene = new Scene(root, 600, 400); //create a new scene size 600, 400
            stage.setScene(newScene); //set the scene to the stage
            stage.setTitle("New User Window"); //sets the title of the new window 
            stage.show(); //show the new window 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end newUserButtonPressed method
}
