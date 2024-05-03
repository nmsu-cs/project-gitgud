package Controllers;

import User.DataUserEntered;
import User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PickingPermitPageController {
    @FXML
    private Button enterButton;

    @FXML
    private TextField parkingPermitTextField;

    DataUserEntered data = DataUserEntered.getInstance();

    @FXML
    private void handleEnterPressed(ActionEvent event) {
        String userInput = parkingPermitTextField.getText().trim();
        // Now check if the inputted the proper number so we can set the data, else it will just return and do nothing else.
        if (userInput.equals("1")) data.setParkingPermitType("Commuter Student Permit (Green)");
        else if (userInput.equals("2")) data.setParkingPermitType("North Residential Student Parking (Yellow)");
        else if (userInput.equals("3")) data.setParkingPermitType("Faculty/Staff Parking (Maroon)");
        else return;

        User newUser = new User(data.getAggieID(), data.getFullName(), data.isHasParkingPermit(), data.getParkingPermitType());

        // Add the new user to the user database
        User.saveUserToFile(newUser, "user_data.txt");

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
