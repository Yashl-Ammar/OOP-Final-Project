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

public class FoodListController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label NoFoodListLabel;

    @FXML
    private ListView RestaurantFoodList;
    @FXML
    private Label AddToCartLabel;
    @FXML
    private ListView PriceViewList;



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
        NoFoodListLabel.setText("");
        AddToCartLabel.setText("");

        for (Restaurant i: Restaurant.Restaurants) {
            if(CustomerLoginController.Selecteditem.equals(i.getRestaurantName()))
            {
                for (Food j: i.foods) {
                    RestaurantFoodList.getItems().add(j.getFoodItem());
                    PriceViewList.getItems().add(j.getPrice());
                }
            }
        }
        RestaurantFoodList.setOnMouseClicked(event ->{
            String SelectedFood = "";
            try {
                SelectedFood = RestaurantFoodList.getSelectionModel().getSelectedItem().toString();

                Boolean B;
                Food temp=new Food();
                for (Restaurant i: Restaurant.Restaurants) {
                    if(CustomerLoginController.Selecteditem.equals(i.getRestaurantName()))
                    {
                        for (Food j: i.foods) {
                            if(SelectedFood.equals(j.getFoodItem()))
                            {
                                temp.setPrice(j.getPrice());
                                temp.setFoodItem(j.getFoodItem());
                            }
                        }
                    }
                }
                Customer c = new Customer();
                B=c.addToCart(temp,Controller.username,CustomerLoginController.Selecteditem);
                if(B)
                {
                    AddToCartLabel.setText("The Food is Being Added to Cart");
                }
                else
                {
                    AddToCartLabel.setText("Unsuccesfully Added to Cart");
                }
            }catch(Exception e)
            {
                NoFoodListLabel.setText("No Food There");
            }

        });
    }
}
