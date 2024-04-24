package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class LoggedInController {
    @FXML
    private Button exitButton; //reference to exit button 

    @FXML
    private Button findParkingButton; //referecne to the find parking button

    @FXML 
    private Button leaveParkingButton; //referecne to the leave paprking button

    @FXML 
    private Button searchParkingButton; //reference to the search parking button

    @FXML
    private Button reportParkingButton; // New private Button field for "Report Parking" button

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end newUserButtonPressed method


    @FXML 
    private void findParkingAction(ActionEvent event) { 
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample6FindPark.fxml"));
            Scene newScene = new Scene(root, 600, 400);
            stage.setScene(newScene);
            stage.setTitle("Find Parking");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML 
    private void searchParkingAction(ActionEvent event) {
        try { 
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample7SearchPark.fxml"));
            Scene newScene = new Scene(root, 600, 400);
            stage.setScene(newScene);
            stage.setTitle("Search Parking");
            stage.show();
        }   catch (IOException e) {
            e.printStackTrace();
            }
        }


    @FXML
    private void reportParkingAction(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sampleReportParking.fxml"));
            Scene newScene = new Scene(root, 600, 400);
            stage.setScene(newScene);
            stage.setTitle("Report Parking");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
