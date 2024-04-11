package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoggedInController {
    @FXML
    private Button exitButton;

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