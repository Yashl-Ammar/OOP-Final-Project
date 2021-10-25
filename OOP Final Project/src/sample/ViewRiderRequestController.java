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
public class ViewRiderRequestController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView RiderNameList;
    @FXML
    private ListView RiderUsernameList;
    @FXML
    private ListView RiderAddressList;
    @FXML
    private ListView RiderEmailList;
    @FXML
    private ListView RiderPhonenumberList;
    @FXML
    private Label AcceptLabel;
    String Selecteditem;
    @FXML
    void initialize()
    {
        RiderUsernameList.setOnMouseClicked(mouseEvent -> {
            try {
                Selecteditem = RiderUsernameList.getSelectionModel().getSelectedItem().toString();
            }catch (Exception w)
            {
                AcceptLabel.setText("Unable to select Rider");
            }
        });

        for(Rider i: Admin.acceptRequestRider)
        {
            RiderNameList.getItems().add(i.getName());
            RiderUsernameList.getItems().add(i.getUsername());
            RiderAddressList.getItems().add(i.getAddress());
            RiderEmailList.getItems().add(i.getPhoneNumber());
            RiderPhonenumberList.getItems().add(i.getPhoneNumber());
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
        for (Rider i: Admin.acceptRequestRider ) {
            if(Selecteditem.equals(i.getUsername()))
            {
                Rider.Riders.add(i);
                AcceptLabel.setText("Rider Added to FOOD ON WHEELS");
                b = true;
                Admin.acceptRequestRider.remove(i);
                break;
            }
        }
        if(!b)
        {
            AcceptLabel.setText("Unable to add the Rider");
        }


    }
    public void RejectRequestButton(ActionEvent e)throws IOException
    {
        Boolean b = false;
        for (Rider i: Admin.acceptRequestRider ) {
            if(Selecteditem.equals(i.getUsername()))
            {
                Admin.acceptRequestRider.remove(i);
                AcceptLabel.setText("You have rejected the Request");
                b = true;
                Admin.acceptRequestRider.remove(i);
                break;
            }
        }
        if(!b)
        {
            AcceptLabel.setText("Unable to reject the Rider");
        }


    }


}
