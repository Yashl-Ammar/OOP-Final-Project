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
public class FoodNameUpdateController {
    @FXML
    private Label FoodNameLabelValidity;
    @FXML
    private TextField FoodNameChange;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void initialize(){
       FoodNameLabelValidity.setText("");
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
        for (Restaurant i : Restaurant.Restaurants)
        {
            if(Controller.username.equals(i.getUsername()))
            {
                for(Food j : i.foods)
                {
                    if(UpdateFoodDetailsController.itemName.equals(j.getFoodItem()))
                    {
                        j.setFoodItem(FoodNameChange.getText());
                        FoodNameLabelValidity.setText("Name Changed");
                        break;
                    }
                }
            }
        }
    }
}
