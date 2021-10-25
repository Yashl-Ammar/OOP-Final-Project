package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerLoginController {
    @FXML
    private Label NoRestaurantLabel;
    @FXML
    private Label CustomerNameLable;
    @FXML
    private ListView ListViewRestaurants;
    @FXML
    private Label CheckDeliveryStatusLabel;

    static String Selecteditem;
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
    void initialize() throws IOException
    {
        CheckDeliveryStatusLabel.setText("");
        CustomerNameLable.setText(Controller.username+" ! ");

        for(Restaurant i : Restaurant.Restaurants) {
            ListViewRestaurants.getItems().add(i.getRestaurantName());
        }
        ListViewRestaurants.setOnMouseClicked(event ->{
            try {
                Selecteditem = ListViewRestaurants.getSelectionModel().getSelectedItem().toString();

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("FoodList.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException e)
                {
                    System.out.println(e);
                }
            }catch(Exception e)
            {
                NoRestaurantLabel.setText("There is no Restaurant There");
            }
        });

    }
    public void ViewCartButton(ActionEvent e) throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("ViewCart.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void DelieveryStatusButton(ActionEvent e) throws IOException
    {
        Customer C=new Customer();
        String B=C.CheckDeliveryStatus(Controller.username);
        CheckDeliveryStatusLabel.setText(B);
    }
    public void CheckOutButton(ActionEvent e) throws  IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CheckoutCustomer.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
