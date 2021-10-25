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

public class AddFoodRestaurantController {
    @FXML
    private Label FoodAddLabelValidility;

    @FXML
    private TextField AddFoodName;
    @FXML
    private TextField AddFoodPrice;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void initialize()
    {
        FoodAddLabelValidility.setText(" ");
    }

    public void backtoLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addingFood()
    {
        Boolean B=false;
        double price = 0;
        try {
            price = Double.parseDouble(AddFoodPrice.getText());
        }catch(Exception e)
        {
            B = true;
        }
        if(!B) {
            Restaurant r1 = new Restaurant();
            B = r1.AddFoodDetail(AddFoodName.getText(), price, Controller.username);
        }
        if(!B) {
            FoodAddLabelValidility.setText("Food Added Successfully");
        }
        else
        {
            FoodAddLabelValidility.setText("Food Already Exists or You have Exceed the Limit");
        }
    }

}
