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

public class CurrentOrderController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label LabelCustomerName;
    @FXML
    private Label LabelPhoneNo;
    @FXML
    private Label LabelAddress;
    @FXML
    private ListView OrdernumberList;
    @FXML
    private ListView FoodsList;
    @FXML
    private ListView TotalPriceList;

    @FXML
    void initialize()
    {
        LabelCustomerName.setText("");
        LabelPhoneNo.setText("");
        LabelAddress.setText("");
        LabelPhoneNo.setText("");
        LabelAddress.setText("");
        for(Rider i:Rider.Riders) {
            if(Controller.username.equals(i.getUsername()))
            {
                LabelCustomerName.setText(i.Acceptorder.c.getName());
                LabelPhoneNo.setText(i.Acceptorder.c.getPhoneNumber());
                LabelAddress.setText(i.Acceptorder.c.getAddress());
                OrdernumberList.getItems().add(i.Acceptorder.getOrdernumber());
                for(int j = 0 ; j < i.Acceptorder.getOrderFood().size() ; j++) {
                    FoodsList.getItems().add(i.Acceptorder.getOrderFood().get(j).getFoodItem());
                }
                TotalPriceList.getItems().add(i.Acceptorder.getTotalPrice());
            }
        }

    }

    public void BackButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("RiderLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void BlockCustomer(ActionEvent e) throws IOException
    {
        for(Rider i : Rider.Riders)
        {
            if(Controller.username.equals(i.getUsername()))
            {
                i.blockedCustomer.add(i.Acceptorder.c);
                Customer c = new Customer();
                Order tempo = new Order();
                i.Acceptorder.setC(c);
                i.Acceptorder.setOrderFood(tempo.getOrderFood());
                i.Acceptorder.setOrdernumber(0);
                i.Acceptorder.setTotalPrice(tempo.getTotalPrice());
            }
        }
    }
    public void CollectCashButton(ActionEvent e)throws IOException
    {
        for(Rider i:Rider.Riders) {
            if(Controller.username.equals(i.getUsername()))
            {
                LabelCustomerName.setText("");
                LabelPhoneNo.setText("");
                LabelAddress.setText("");

                for(Customer j : Customer.Customers)
                {
                    if(j.getUsername().equals(i.Acceptorder.c.getUsername()))
                    {
                        j.Orderhistory.add(i.Acceptorder);
                    }
                }

                Customer c = new Customer();
                Order tempo = new Order();
                i.Acceptorder.setC(c);
                i.Acceptorder.setOrderFood(tempo.getOrderFood());
                i.Acceptorder.setOrdernumber(0);
                i.Acceptorder.setTotalPrice(tempo.getTotalPrice());

                OrdernumberList.getItems().add("");
                for(int j = 0 ; j < i.Acceptorder.getOrderFood().size() ; j++) {
                    FoodsList.getItems().add("");
                }
                TotalPriceList.getItems().add(0);
            }
        }
    }
}