package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {
    @FXML
    private Button homeButton;

    @FXML
    public void homeButtonPressed(ActionEvent event){
        try{
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample2.fxml"));
            Scene secondaryScene = new Scene(root, 1200, 720);
            stage.setScene(secondaryScene);
            stage.setTitle("HI");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
