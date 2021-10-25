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

public class DeleteFoodController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField DeleteItemTextField;
    @FXML
    private  Label DeleteFoodLabelValidity;

    @FXML
    public void initialize()
    {
        DeleteFoodLabelValidity.setText(" ");
    }

    public void backtoRestaurantLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void DeleteButton(ActionEvent e) throws IOException
    {
        Boolean B=false;
       Restaurant R=new Restaurant();
       B=R.DeleteFood(DeleteItemTextField.getText(),Controller.username);
       if(B)
       {
            DeleteFoodLabelValidity.setText("Food Deleted Successfully");
       }
       else
       {
           DeleteFoodLabelValidity.setText("Food Deleted Unsucessfully");
       }

    }
}
