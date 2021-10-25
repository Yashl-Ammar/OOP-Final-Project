package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class UpdateFoodDetailsController {


    static String itemName;
    @FXML
    public TextField UpdateItemName;
    @FXML
    public Label UpdateFoodNameLabel;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize(){
        UpdateFoodNameLabel.setText("");
    }

    public void backButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void UpdateButton(ActionEvent e) throws IOException {
        itemName = UpdateItemName.getText();
        Restaurant r = new Restaurant();
        Boolean b = r.UpdateFoodDetails(itemName,Controller.username);
        if (b)
        {
            Parent root = FXMLLoader.load(getClass().getResource("UpdateFoodDetails2.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        UpdateFoodNameLabel.setText("This Food doesn't exist");

    }

}