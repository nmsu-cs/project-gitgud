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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import User.DataUserEntered;

public class FindParkingController{

    @FXML
    private ListView<String> listView;

    @FXML
    private ListView<String> lotsAvailableList;

    @FXML
    private Button backButton;

    @FXML
    private Button showMapButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField parkingLotInput;

    @FXML
    private Image mapImage;

    DataUserEntered data = DataUserEntered.getInstance();

    @FXML
    private void initialize() {
        System.out.println(data.getParkingPermitType());

        // Create a list of items
        ObservableList<String> items = FXCollections.observableArrayList();
        if(data.getParkingPermitType().equals("Commuter Student Permit (Green)")){
            //System.out.println("found match");
            mapImage = new Image("img/map.jpg");
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
            mapImage = new Image("img/map2.jpg");
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
            mapImage = new Image("img/map3.jpg");
            items.add("Science Hall Lot 58");
            items.add("Corbett Lot 17");
            items.add("Zuhl Libaray Lot 45");
            items.add("Satellite Lot 100");
            items.add("Rent Frow Lot 48");
            items.add("Skeens Lot 4");
            items.add("Chamisa Village Lot 38");
            items.add("Horseshoe Lot");
        }
        else {
            return;
        }

        // Populate the ListView with the list of items
        listView.setItems(items);

        listView.setOnMouseClicked(event -> loadAvailableParkingLots());
    }

    @FXML
    public void showMapButtonPressed(ActionEvent event) {
        ImageView imageView = new ImageView(mapImage);
        imageView.setFitWidth(1200); // Set the width to 1200
        imageView.setFitHeight(720); // Set the height to 720
        imageView.setPreserveRatio(true);

        StackPane layout = new StackPane(imageView);

        Stage mapStage = new Stage();
        mapStage.setScene(new Scene(layout));
        mapStage.setTitle("Map");
        mapStage.show();
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

    @FXML
    private void submitButtonPressed(ActionEvent event) {
        String selectedParkingSpace = lotsAvailableList.getSelectionModel().getSelectedItem();
        String selectedParkingLot = listView.getSelectionModel().getSelectedItem();

        if (selectedParkingSpace != null && selectedParkingLot != null) {

            // Store the selected parking spot
            data.setSelectedParkingSpot(selectedParkingSpace);
            data.setSelectedParkingLot(selectedParkingLot);

            // Mark the selected parking space as taken
            markParkingSpaceAsTaken(selectedParkingSpace, "1");
        } else {
            System.out.println("Please select a parking lot and a parking space.");
        }
    }



    @FXML
    private void loadAvailableParkingLots() {
        String selectedParkingLot = listView.getSelectionModel().getSelectedItem();
        if (selectedParkingLot != null) {
            lotsAvailableList.getItems().clear();

            // Map parking lot names to their corresponding file names
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

            // Get the filename for the selected parking lot name
            String fileName = fileNames.get(selectedParkingLot);
            if (fileName != null) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 2 && parts[1].equals("0")) {
                            lotsAvailableList.getItems().add(parts[0]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File not found for parking lot: " + selectedParkingLot);
            }
        }
    }

    @FXML
    private void markParkingSpaceAsTaken(String parkingSpace, String availability) {
        String selectedParkingLot = listView.getSelectionModel().getSelectedItem();
        if (selectedParkingLot != null) {
            // Get the file name for the selected parking lot from the map
            Map<String, String> fileNames = getFileNames();
            String fileName = fileNames.get(selectedParkingLot);
            
            if (fileName != null) {
                try {
                    // Construct the temporary file name
                    File originalFile = new File(fileName);
                    System.out.println(fileName);
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
                    if (tempFile.exists()) System.out.println("File exists");
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
        } else {
            System.out.println("Please select a parking lot.");
        }
    }



    @FXML
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