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

public class FoodPriceUpdateController {
    @FXML
    private Label FoodNameLabelValidity1;
    @FXML
    private TextField FoodNameChange1;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void initialize(){
       FoodNameLabelValidity1.setText("");
    }
    public void backButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ChangeButton(ActionEvent e) throws IOException
    {
        double x = 0;
        boolean b = false;
        try {
            x = Double.parseDouble(FoodNameChange1.getText());
        }catch (Exception exception)
        {
            b = true;
        }
        if (!b) {
            for (Restaurant i : Restaurant.Restaurants) {
                if (Controller.username.equals(i.getUsername())) {
                    for (Food j : i.foods) {
                        if (UpdateFoodDetailsController.itemName.equals(j.getFoodItem())) {
                            j.setPrice(x);
                            FoodNameLabelValidity1.setText("Price Changed");
                            break;
                        }
                    }
                }
            }
        }
    }
}
