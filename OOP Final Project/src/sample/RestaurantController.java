package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.IOException;

public class RestaurantController {
    @FXML
    private Label RestaurentLabelName;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void backtoLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void initialize()
    {
        RestaurentLabelName.setText(Controller.username+"!");
    }

    public void ADD_FOOD_DETAILS_BUTTON(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddFood.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void UPDATE_FOOD_DETAILS_BUTTON(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UpdateFoodDetails.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void DELETE_FOOD(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteFood.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CHECK_FOOD_ORDER(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CHECKFOODORDER.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
