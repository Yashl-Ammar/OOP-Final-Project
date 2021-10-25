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

public class AdminCustomerRemoverController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView CustomerRemoveList;
    @FXML
    private Label CustomerRemoveLabel;

    public void BackButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void initialize()
    {
        CustomerRemoveLabel.setText("");
        for (Customer i:Customer.Customers) {
            CustomerRemoveList.getItems().add(i.getUsername());
        }
        CustomerRemoveList.setOnMouseClicked(mouseEvent -> {
            try {
                Boolean B=false;
                String Selecteditem = CustomerRemoveList.getSelectionModel().getSelectedItem().toString();
                for (Customer i: Customer.Customers) {
                    if(Selecteditem.equals(i.getUsername()))
                    {
                        Customer.Customers.remove(i);
                        B=true;
                        CustomerRemoveLabel.setText("Customer Remove Successfully");
                        break;
                    }
                }
                if(!B)
                {
                    CustomerRemoveLabel.setText("Customer Remove Unsuccessfully");
                }
            }catch (Exception w)
            {
                CustomerRemoveLabel.setText("Customer Remove Unsuccessfully");
            }

        });

    }
}
