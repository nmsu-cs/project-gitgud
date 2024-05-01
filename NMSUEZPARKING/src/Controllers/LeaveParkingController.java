package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import User.DataUserEntered;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LeaveParkingController {
    
    @FXML 
    private Button backToMainMenu;

    @FXML
    private Button submitButtonPressed;

    DataUserEntered data = DataUserEntered.getInstance();

    @FXML
    private void backButtonPressed(ActionEvent event){
        try {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample2.fxml"));
            Scene newScene = new Scene(root, 600, 400);
            stage.setScene(newScene);
            stage.setTitle("New User Window");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void submitButtonPressed(ActionEvent event) {
        // Retrieve the selected parking spot
        String selectedParkingSpot = data.getSelectedParkingSpot();
        if (selectedParkingSpot != null) {
            // Mark the selected parking space as available
            markParkingSpaceAsTaken(selectedParkingSpot, "0");
            // Optionally, clear the selected parking spot from the data storage
            DataUserEntered.getInstance().setSelectedParkingSpot(null);
        } else {
            System.out.println("No parking spot selected.");
        }
    }


    private void markParkingSpaceAsTaken(String parkingSpace, String availability) {
        // Get the file name for the selected parking lot from the map
        Map<String, String> fileNames = getFileNames();
        String selectedParkingLot = data.getSelectedParkingLot();
        String fileName = fileNames.get(selectedParkingLot);

        if (fileName != null) {
            try {
                // Construct the temporary file name
                File originalFile = new File(fileName);
                String parentDirectory = originalFile.getParent();
                String tempFileName = parentDirectory + File.separator + "temp_" + originalFile.getName();

                try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {
                    String line;
                    boolean spaceUpdated = false;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 2 && parts[0].equals(parkingSpace)) {
                            writer.write(parkingSpace + "," + availability + "\n");
                            spaceUpdated = true;
                        } else {
                            writer.write(line + "\n");
                        }
                    }
                    if (!spaceUpdated) {
                        // If the parking space was not found, add it to the end of the file
                        writer.write(parkingSpace + "," + availability + "\n");
                    }
                }

                // Replace the original file with the updated file
                File tempFile = new File(tempFileName);
                if (tempFile.exists() && originalFile.exists()) {
                    originalFile.delete();
                    tempFile.renameTo(originalFile);
                    System.out.println("Parking space " + parkingSpace + " in " + selectedParkingLot + " successfully marked as " + (availability.equals("1") ? "taken" : "available"));
                    } else {
                        System.out.println("Failed to update parking space.");
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File name not found for parking lot: " + selectedParkingLot);
        }
    }

    private Map<String, String> getFileNames() {
        
        Map<String, String> fileNames = new HashMap<>();
        fileNames.put("Juniper Hall Lot 19", "NMSUEZPARKING/src/parking_lot_data/JuniperLot.txt");
        fileNames.put("Garcia Hall Lot 23", "NMSUEZPARKING/src/parking_lot_data/GarciaLot23.txt");
        fileNames.put("Garcia Hall Lot 22 Behind Lot 23", "NMSUEZPARKING/src/parking_lot_data/GarciaLot22.txt");
        fileNames.put("Pinon Hall Lot 27", "NMSUEZPARKING/src/parking_lot_data/PinonLot.txt");
        fileNames.put("Track Lot 100S","NMSUEZPARKING/src/parking_lot_data/TrackLot100S.txt");
        fileNames.put("O'Donald Lot 55", "NMSUEZPARKING/src/parking_lot_data/O'DonaldLot.txt");
        fileNames.put("Bookstore Lot 16","NMSUEZPARKING/src/parking_lot_data/BookstoreLot.txt");
        fileNames.put("Satellite Lot 100","NMSUEZPARKING/src/parking_lot_data/SatelliteLot.txt");
        fileNames.put("Rent Frow Lot 48", "NMSUEZPARKING/src/parking_lot_data/RentFrowLot.txt");
        fileNames.put("Skeens Lot 4","NMSUEZPARKING/src/parking_lot_data/SkeensLot.txt");
        fileNames.put("Chamisa Village Lot 38", "NMSUEZPARKING/src/parking_lot_data/ChamisaVillageLot.txt");
        fileNames.put("Horseshoe Lot", "NMSUEZPARKING/src/parking_lot_data/HorseshoeLot.txt");
        fileNames.put("Science Hall Lot 58", "NMSUEZPARKING/src/parking_lot_data/ScienceHallLot.txt");
        fileNames.put("Corbett Lot 17","NMSUEZPARKING/src/parking_lot_data/CorbettLot.txt");
        fileNames.put("Zuhl Library Lot 45", "NMSUEZPARKING/src/parking_lot_data/ZuhlLibraryLot.txt");

        return fileNames;
    }
}
