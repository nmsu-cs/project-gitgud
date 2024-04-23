package Controllers;


//import User.User;
//import User.UserDataLoader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class reportParkingController {

    @FXML
    private TextField makeField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField colorField;

    @FXML
    private TextField parkingLotField;

    @FXML
    private TextField reasonField;

    @FXML
    private Button submitButton; //reference to the submit button

    @FXML
    private Button backButton; //reference to the back button

    @FXML
    public void backButtonPressed(ActionEvent event) {
        // Add your code here to handle the action when the back button is pressed
        try {
            // Load the main menu scene
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
            Scene newScene = new Scene(root, 600, 400);
            stage.setScene(newScene);
            stage.setTitle("Main Menu");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void submitButtonPressed(ActionEvent event) {
        // Retrieve text input from the text fields
        String make = makeField.getText();
        String model = modelField.getText();
        String color = colorField.getText();
        String parkingLot = parkingLotField.getText();
        String reason = reasonField.getText();

        System.out.println("Thank you for reporting, we will handle the situation");

        // Save the input data to a text file
        saveReport(make, model, color, parkingLot, reason);
    }

    // Method to save report
    private static void saveReport(String make, String model, String color, String parkingLot, String reason) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("report_data.txt", true))) {
            writer.println(make + "," + model + "," + color + "," + parkingLot + "," + reason);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
