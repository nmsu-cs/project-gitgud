package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SearchParkingController {

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<String> availableLotsList;

    @FXML
    private TextField lotNumberField;

    @FXML 
    private Button backToMainMenuButton; 

    private List<String> parkingLots;

    @FXML
    private void initialize() {
        // Create a list of parking lots
        parkingLots = new ArrayList<>();
        parkingLots.add("Juniper Lot");
        parkingLots.add("Garcia Lot 23");
        parkingLots.add("Garcia Lot 22");
        parkingLots.add("Pinon Lot");
        parkingLots.add("Track Lot 100S");
        parkingLots.add("O'Donald Lot");
        parkingLots.add("Bookstore Lot");
        parkingLots.add("Satellite Lot");
        parkingLots.add("Rent Frow Lot");
        parkingLots.add("Skeens Lot");
        parkingLots.add("Chamisa Village Lot");
        parkingLots.add("Horseshoe Lot");
        parkingLots.add("Science Hall Lot");
        parkingLots.add("Corbett Lot");
        parkingLots.add("Zuhl Library Lot");
    
        // Populate the ListView with the list of parking lots
        listView.getItems().addAll(parkingLots);
    
        // Set listener for the listView selection
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String selectedParkingLot = listView.getSelectionModel().getSelectedItem();
                if (selectedParkingLot != null) {
                    loadParkingLotData(selectedParkingLot);
                }
            }
        });
    }

    private void loadParkingLotData(String parkingLotName) {
        availableLotsList.getItems().clear(); // Clear previous data

        // Map parking lot names to their corresponding file names
        Map<String, String> fileNames = new HashMap<>();
        fileNames.put("Juniper Lot", "NMSUEZPARKING/src/parking_lot_data/JuniperLot.txt");
        fileNames.put("Garcia Lot 23", "NMSUEZPARKING/src/parking_lot_data/GarciaLot23.txt");
        fileNames.put("Garcia Lot 22", "NMSUEZPARKING/src/parking_lot_data/GarciaLot22.txt");
        fileNames.put("Pinon Lot", "NMSUEZPARKING/src/parking_lot_data/PinonLot.txt");
        fileNames.put("Track Lot 100S","NMSUEZPARKING/src/parking_lot_data/TrackLot100S.txt");
        fileNames.put("O'Donald Lot", "NMSUEZPARKING/src/parking_lot_data/O'DonaldLot.txt");
        fileNames.put("Bookstore Lot","NMSUEZPARKING/src/parking_lot_data/BookstoreLot.txt");
        fileNames.put("Satellite Lot","NMSUEZPARKING/src/parking_lot_data/SatelliteLot.txt");
        fileNames.put("Rent Frow Lot", "NMSUEZPARKING/src/parking_lot_data/RentFrowLot.txt");
        fileNames.put("Skeens Lot","NMSUEZPARKING/src/parking_lot_data/SkeensLot.txt");
        fileNames.put("Chamisa Village Lot", "NMSUEZPARKING/src/parking_lot_data/ChamisaVillageLot.txt");
        fileNames.put("Horseshoe Lot", "NMSUEZPARKING/src/parking_lot_data/HorseshoeLot.txt");
        fileNames.put("Science Hall Lot", "NMSUEZPARKING/src/parking_lot_data/ScienceHallLot.txt");
        fileNames.put("Corbett Lot","NMSUEZPARKING/src/parking_lot_data/CorbettLot.txt");
        fileNames.put("Zuhl Library Lot", "NMSUEZPARKING/src/parking_lot_data/ZuhlLibraryLot.txt");


        // Get the filename for the selected parking lot name
        String fileName = fileNames.get(parkingLotName);
        if (fileName != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2 && parts[1].equals("0")) {
                        availableLotsList.getItems().add(parts[0]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found for parking lot: " + parkingLotName);
        }
    }
   

    @FXML
    private void handleSubmitButtonAction() {
        String selectedLot = availableLotsList.getSelectionModel().getSelectedItem();
        if (selectedLot != null) {
            // Do something with the selected lot
            System.out.println("Selected Lot: " + selectedLot);
        } else {
            System.out.println("Please select a parking lot.");
        }
    }


    //back button method that takes you back to main menu 
    @FXML
    private void handleBackToMainMenuButtonAction() {
        // Load the main menu FXML file
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
            Scene scene = new Scene(root);

            // Get the stage from the current button's scene and set the new scene
            Stage stage = (Stage) backToMainMenuButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Main Menu");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}