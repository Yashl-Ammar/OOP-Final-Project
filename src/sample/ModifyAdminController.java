package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ModifyAdminController {
    private Stage stage;
    private Scene scene;
    private Parent root;
@FXML
    private TextField CurrentUsername;
@FXML
    private TextField NewUsername;
@FXML
    private PasswordField OldPassword;
@FXML
    private PasswordField NewPassword;
@FXML
    private Label InvalidCredentials;
@FXML
    void initialize()
    {
      InvalidCredentials.setText("");
    }
    public void ModifyButton(ActionEvent e)throws IOException
    {
        String Username=CurrentUsername.getText();
        String NewUsername1=NewUsername.getText();
        String Password=OldPassword.getText();
        String NewPassword1=NewPassword.getText();
        Boolean B=false;
        for(Admin i:Admin.Admins)
        {
            if(Controller.username.equals(i.getUsername()))
            {
                if(Username.equals(i.getUsername()) && Password.equals(i.getPassword())) {
                    i.setUsername(NewUsername1);
                    i.setPassword(NewPassword1);
                    InvalidCredentials.setText("Your Username and Password has been Changed");
                    B = true;
                }
            }

        }
        if(!B)
        {
            InvalidCredentials.setText("Invalid Credentials");
        }
    }
    public void BackButton(ActionEvent e)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
