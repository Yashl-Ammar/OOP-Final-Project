package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ViewRestaurantRequestController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView ListofRestaurantNames;
    @FXML
    private ListView ListRestaurantUsername;
    @FXML
    private ListView ListOwnerName;
    @FXML
    private ListView ListRestaurantPhoneNumber;
    @FXML
    private ListView ListRestaurantEmail;
    @FXML
    private Label AcceptLabel;
    String Selecteditem;
    @FXML
    void initialize()
    {
        ListRestaurantUsername.setOnMouseClicked(mouseEvent -> {
            try {
        Selecteditem = ListRestaurantUsername.getSelectionModel().getSelectedItem().toString();
            }catch (Exception w)
            {
                AcceptLabel.setText("Unable to select Restaurant");
            }
        });

        for(Restaurant i: Admin.acceptRequestRestaurants)
        {
            ListofRestaurantNames.getItems().add(i.getRestaurantName());
            ListRestaurantUsername.getItems().add(i.getUsername());
            ListOwnerName.getItems().add(i.getName());
            ListRestaurantPhoneNumber.getItems().add(i.getPhoneNumber());
            ListRestaurantEmail.getItems().add(i.getRestaurantMail());
        }
    }
    public void BackButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void AcceptRequestButton(ActionEvent e)throws IOException
    {
        Boolean b = false;
                for (Restaurant i: Admin.acceptRequestRestaurants ) {
                    if(Selecteditem.equals(i.getUsername()))
                    {
                        Restaurant.Restaurants.add(i);
                        AcceptLabel.setText("Restaurant Added to FOOD ON WHEELS");
                        b = true;
                        Admin.acceptRequestRestaurants.remove(i);
                        break;
                    }
                }
                if(!b)
                {
                    AcceptLabel.setText("Unable to add the Restaurant");
                }


    }
    public void RejectRequestButton(ActionEvent e)throws IOException
    {
        Boolean b = false;
                for (Restaurant i: Admin.acceptRequestRestaurants ) {
                    if(Selecteditem.equals(i.getUsername()))
                    {
                        Admin.acceptRequestRestaurants.remove(i);
                        AcceptLabel.setText("You have rejected the Request");
                        b = true;
                        Admin.acceptRequestRestaurants.remove(i);
                        break;
                    }
                }
                if(!b)
                {
                    AcceptLabel.setText("Unable to reject the Restaurant");
                }


    }
}
