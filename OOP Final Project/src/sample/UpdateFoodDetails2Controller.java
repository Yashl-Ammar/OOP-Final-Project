package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateFoodDetails2Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void backButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void UpdateFoodName(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FoodNameUpdate.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void UpdateFoodPrice(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FoodPriceUpdate.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
