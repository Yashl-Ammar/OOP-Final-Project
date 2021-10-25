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

public class RiderLoginController {
    @FXML
    private Label RiderAssuranceLabel;
    @FXML
    private ListView OrderNumberListViewRider;
    @FXML
    private ListView OrderFoodsListViewRider;
    @FXML
    private ListView OrderStatusListViewRider;
    @FXML
    private ListView OrderTotalPriceListViewRider;
    @FXML
    private ListView CustomerAddressList;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void Logout(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CurrentOrder(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CurrentOrder.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        RiderAssuranceLabel.setText("");
        OrderNumberListViewRider.setOnMouseClicked(mouseEvent -> {
            try {
                Boolean b = false;
                String Selecteditem = OrderNumberListViewRider.getSelectionModel().getSelectedItem().toString();
                for (Rider i : Rider.Riders) {
                    if (Controller.username.equals(i.getUsername())) {
                        for (Order k : Rider.RidersOrder) {
                            for(Customer l : i.blockedCustomer)
                            {
                                if(l.getUsername().equals(k.c.getUsername()))
                                {
                                    RiderAssuranceLabel.setText("This Customer is Blocked By You");
                                    b = true;
                                    break;
                                }

                            }
                            if(!b) {
                                if (i.Acceptorder.getTotalPrice() == 0) {
                                    if (Selecteditem.equals(String.valueOf(k.getOrdernumber()))) {
                                        i.Acceptorder.setC(k.getC());
                                        i.Acceptorder.setOrderFood(k.getOrderFood());
                                        i.Acceptorder.setOrdernumber(k.getOrdernumber());
                                        i.Acceptorder.setTotalPrice(k.getTotalPrice());
                                        RiderAssuranceLabel.setText("You have Accepted The Order");
                                        Rider.RidersOrder.remove(k);
                                        break;
                                    }
                                } else {
                                    System.out.println("Order already taken");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                RiderAssuranceLabel.setText("There is No order Over There");
            }
        });
        int counter = 0;
        for (Order k : Rider.RidersOrder) {
            CustomerAddressList.getItems().add(k.c.getAddress());
            OrderStatusListViewRider.getItems().add(k.getStatus());
            for (Food l : k.OrderFood) {
                OrderFoodsListViewRider.getItems().add(l.getFoodItem());
                counter++;
            }
            OrderNumberListViewRider.getItems().add(k.getOrdernumber());
            OrderTotalPriceListViewRider.getItems().add(k.getTotalPrice());
            for(int i = 0 ; i < counter-1; i++)
            {
                OrderNumberListViewRider.getItems().add(" ");
                OrderTotalPriceListViewRider.getItems().add(" ");
                CustomerAddressList.getItems().add(" ");
                OrderStatusListViewRider.getItems().add(" ");
            }
        }
    }
}
