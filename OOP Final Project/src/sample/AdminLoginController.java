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
import java.io.IOException;

public class AdminLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label AdminUsernameLabel;
    @FXML
    void initialize()
    {
        AdminUsernameLabel.setText("");
        AdminUsernameLabel.setText(Controller.username);
    }
    public void LogoutButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ModifyIDandPasswordButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ModifyAdmin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ViewRestaurantRequestButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewRestaurantRequest.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void ViewRiderRequestButton(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewRiderRequest.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void RemoveCustomer(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminCustomerRemover.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
