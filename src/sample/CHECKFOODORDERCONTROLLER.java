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

public class CHECKFOODORDERCONTROLLER {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label UpdateOrderStatusLabel;
    @FXML
    private ListView OrderNumberListView;
    @FXML
    private ListView TotalPriceList ;
    @FXML
    private ListView FooodItemLabel;
    @FXML
    private ListView OrderStatusList;

    public void BackButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize()
    {
        UpdateOrderStatusLabel.setText("");

        int counter = 0;

        try {

            OrderNumberListView.setOnMouseClicked(mouseEvent -> {
                String Selecteditem = OrderNumberListView.getSelectionModel().getSelectedItem().toString();
                String S=Selecteditem;
                for (Restaurant i: Restaurant.Restaurants)
                {
                    if(i.getUsername().equals(Controller.username))
                    {
                        for(Order j : i.OrderList)
                        {
                            if(S.equals(String.valueOf(j.getOrdernumber())))
                            {
                                j.setStatus("Order Given to Rider");
                                Rider.RidersOrder.add(j);
                                i.OrderList.remove(j);
                                UpdateOrderStatusLabel.setText("Order status has been updated");
                                break;
                            }
                        }
                    }
                }
            });
        }
        catch(Exception e) {
            e.printStackTrace();
            UpdateOrderStatusLabel.setText("There is no Order Number there");
        }
        for(Restaurant i: Restaurant.Restaurants ) {
            if (Controller.username.equals(i.getUsername())) {
                for (Order j : i.OrderList) {
                    for (Food k : j.OrderFood) {
                        System.out.println();
                        FooodItemLabel.getItems().add(k.getFoodItem());
                        counter++;
                    }
                    String temp = ""+j.getOrdernumber();
                    OrderNumberListView.getItems().add(temp);
                    TotalPriceList.getItems().add(j.getTotalPrice());
                    OrderStatusList.getItems().add(j.getStatus());
                    for(int k =0 ; k < counter-1 ; k++)
                    {
                        OrderNumberListView.getItems().add(" ");
                        TotalPriceList.getItems().add(" ");
                        OrderStatusList.getItems().add(" ");
                    }
                    OrderNumberListView.getItems().add(" ");
                    FooodItemLabel.getItems().add(" ");
                    TotalPriceList.getItems().add(" ");
                    OrderStatusList.getItems().add(" ");
                }

            }

        }

    }
}
