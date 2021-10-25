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
import java.util.ListIterator;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class ViewCartController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView CustomerCartViewList1;
    @FXML
    private ListView CustomerCartViewList2;
    @FXML
    private Label placeOrderLabel;


    @FXML
    private Label TotalPriceShowLabel;




    @FXML
    void initialize() throws IOException
    {
        placeOrderLabel.setText("");
        double total = 0;
        for(Customer j: Customer.Customers)
        {
            if(Controller.username.equals(j.getUsername()))
            {
                for (Food i : j.Cart)
                {
                    CustomerCartViewList1.getItems().add(i.getFoodItem());
                    CustomerCartViewList2.getItems().add(i.getPrice());
                    total += i.getPrice();
                }
            }
        }
        TotalPriceShowLabel.setText(""+total + " /Rs");
    }
    public void backtoLoginPage(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("LoginCustomer.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void emptyCart(ActionEvent e) throws IOException {

        TotalPriceShowLabel.setText("");
        for (Customer j : Customer.Customers) {
            if (Controller.username.equals(j.getUsername())) {
                ListIterator<Food> iter = j.Cart.listIterator();
                while(iter.hasNext()){
                    Food i = iter.next();;
                    CustomerCartViewList1.getItems().removeAll(i.getFoodItem());
                    CustomerCartViewList2.getItems().removeAll(i.getPrice());
                    iter.remove();

                }
            }
        }

    }
    public void PlaceOrderButton(ActionEvent e) throws IOException
    {
        Customer C=new Customer();
        boolean b = C.placeOrder(Controller.username);
        if(!b) {
            placeOrderLabel.setText("Your order has been Placed");
        }else
        {
            placeOrderLabel.setText("Your order was not Placed or Cart is Empty");
        }
    }
    public void CancelOrder(ActionEvent e) throws IOException {

        Customer C = new Customer();
        Boolean B = C.cancelOrder(Controller.username);
        if (B) {
            placeOrderLabel.setText("Your Order is Being Cancelled");
        }
        else
        {
            placeOrderLabel.setText("Your Order Was not Cancelled");
        }
    }



}
