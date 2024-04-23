package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import User.DataUserEntered;

public class FindParkingController{

    @FXML
    private ListView<String> listView;

    @FXML
    private Button backButton;

    DataUserEntered data = DataUserEntered.getInstance();

    @FXML
    private void initialize() {
        System.out.println(data.getParkingPermitType());

        // Create a list of items
        ObservableList<String> items = FXCollections.observableArrayList();
        if(data.getParkingPermitType().equals("Commuter Student Permit (Green)")){
            //System.out.println("found match");
            items.add("O'Donald Lot 55");
            items.add("Bookstore Lot 16");
            items.add("Track Lot 100S");
            items.add("Satellite Lot 100");
            items.add("Rent Frow Lot 48");
            items.add("Skeens Lot 4");
            items.add("Chamisa Village Lot 38");
            items.add("Horseshoe Lot");
        }
        else if (data.getParkingPermitType().equals("North Residential Student Parking (Yellow)")){
            //System.out.println("found match");
            items.add("Juniper Hall Lot 19");
            items.add("Garcia Hall Lot 23");
            items.add("Garcia Hall Lot 22 Behind Lot 23");
            items.add("Pinon Hall Lot 27");
            items.add("Track Lot 100S");
            items.add("Satellite Lot 100");
            items.add("Rent Frow Lot 48");
            items.add("Skeens Lot 4");
            items.add("Chamisa Village Lot 38");
            items.add("Horseshoe Lot");
        }
        else if (data.getParkingPermitType().equals("Faculty/Staff Parking (Maroon)")){
            items.add("Science Hall lot 58");
            items.add("Corbett lot 17");
            items.add("Zuhl Libaray lot 45");
            items.add("Track Lot 100S");
            items.add("Satellite Lot 100");
            items.add("Rent Frow Lot 48");
            items.add("Skeens Lot 4");
            items.add("Chamisa Village Lot 38");
            items.add("Horseshoe Lot");
        }
        else return;

        // Populate the ListView with the list of items
        listView.setItems(items);
    }

    @FXML
    public void backButtonPressed(ActionEvent event) {
        // Add your code here to handle the action when the back button is pressed
        try {
            // Load the main menu scene
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample2.fxml"));
            Scene newScene = new Scene(root, 600, 400);
            stage.setScene(newScene);
            stage.setTitle("Main Menu");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
