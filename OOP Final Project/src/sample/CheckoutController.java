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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class CheckoutController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label TotalPriceLabel;
    @FXML
    private ListView FoodNameList;
    @FXML
    private ListView FoodPriceList;
    public void BackButton(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("LoginCustomer.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void initialize()
    {
        TotalPriceLabel.setText("");
        for(Customer i : Customer.Customers)
        {
            if(Controller.username.equals(i.getUsername()))
            {
                for(Restaurant j : Restaurant.Restaurants)
                {
                    for(Order k : j.OrderList)
                    {
                        if(Controller.username.equals(k.c.getUsername()))
                        {
                            for(Food l : k.OrderFood)
                            {
                                FoodNameList.getItems().add(l.getFoodItem());
                                FoodPriceList.getItems().add(l.getPrice());
                            }
                            TotalPriceLabel.setText(""+k.getTotalPrice());
                            break;
                        }
                    }
                }
            }
        }
    }

}
