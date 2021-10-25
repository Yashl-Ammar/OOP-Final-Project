package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Controller  {

    static String username;
    // login
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Label invalidCredentialsLabel;
    //customer registration
    @FXML
    public TextField CustomerRegisterUsername;
    @FXML
    public TextField CustomerRegisterName;
    @FXML
    public PasswordField CustomerRegisterPassword;
    @FXML
    public TextField CustomerRegisterEmail;
    @FXML
    public TextField CustomerRegisterPhoneNumber;
    @FXML
    public TextField CustomerRegisterAddress;
   @FXML
   public TextField RestaurantRegisterOwnerName;
   @FXML
   public TextField RestaurantRegisterUsername;
   @FXML
   public TextField RestaurantRegisterRestaurantName;
   @FXML
   public TextField RestaurantRegisterRestaurantContactinfo;
   @FXML
   public TextField RestaurantRegisterOwnerEmail;
   @FXML
   public TextField RestaurantRegisterRestaurantMail;
   @FXML
   public TextField RestaurantRegisterOwnerAddress;
   @FXML
   public TextField RestaurantRegisterOwnerPhoneNumber;
   @FXML
   public TextField RestaurantRegisterRestaurantAddress;
   @FXML
   public PasswordField RestaurantRegisterPassword;

   @FXML
   public TextField RiderRegisterUsername;
    @FXML
    public TextField RiderRegisterPassword;
    @FXML
    public TextField RiderRegisterName;
    @FXML
    public TextField RiderRegisterPhoneNumber;
    @FXML
    public TextField RiderRegisterEmail;
    @FXML
    public TextField RiderRegisterAddress;

    @FXML
    public Label CustomerRegisterConfirmationLAbel;

    @FXML
    public Label RestaurantRegisterConfirmationLAbel;
    @FXML
    public Label RiderRegisterConfirmationLAbel;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void CustomerRegisterButton(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterCustomer.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void RestaurantRegisterButton(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterRestaurant.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void RiderCustomerButton(ActionEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("RiderRegistration.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void close(ActionEvent e)
    {
        for(Customer i : Customer.Customers) {
            try {
                FileWriter fileWriter = new FileWriter("src\\Customer\\"+i.getUsername()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                printWriter.println(i.getUsername());
                printWriter.println(i.getPassword());
                printWriter.println(i.getAddress());
                printWriter.println(i.getEmail());
                printWriter.println(i.getName());
                printWriter.println(i.getPhoneNumber());

                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception exception)
            {
                System.out.println("Error while writing customer while closeing");
            }
        }

        for(Restaurant i : Restaurant.Restaurants) {
            try {
                FileWriter fileWriter = new FileWriter("src\\Restaurant\\"+i.getUsername()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                printWriter.println(i.getUsername());
                printWriter.println(i.getPassword());
                printWriter.println(i.getAddress());
                printWriter.println(i.getEmail());
                printWriter.println(i.getName());
                printWriter.println(i.getPhoneNumber());
                printWriter.println(i.getRestaurantAddress());
                printWriter.println(i.getRestaurantContactNumber());
                printWriter.println(i.getRestaurantMail());
                printWriter.println(i.getRestaurantName());

                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception exception)
            {
                System.out.println("Error while writing restaurant while closeing");
            }
        }

        for(Rider i : Rider.Riders) {
            try {
                FileWriter fileWriter = new FileWriter("src\\Rider\\"+i.getUsername()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                printWriter.println(i.getUsername());
                printWriter.println(i.getPassword());
                printWriter.println(i.getAddress());
                printWriter.println(i.getEmail());
                printWriter.println(i.getName());
                printWriter.println(i.getPhoneNumber());

                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception exception)
            {
                System.out.println("Error while rider customer while closeing");
            }
        }

        for(Restaurant i : Admin.acceptRequestRestaurants) {
            try {
                FileWriter fileWriter = new FileWriter("src\\RestaurantRequest\\"+i.getUsername()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                printWriter.println(i.getUsername());
                printWriter.println(i.getPassword());
                printWriter.println(i.getAddress());
                printWriter.println(i.getEmail());
                printWriter.println(i.getName());
                printWriter.println(i.getPhoneNumber());
                printWriter.println(i.getRestaurantAddress());
                printWriter.println(i.getRestaurantContactNumber());
                printWriter.println(i.getRestaurantMail());
                printWriter.println(i.getRestaurantName());

                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception exception)
            {
                System.out.println("Error while writing customer while closeing");
            }
        }

        for(Rider i : Admin.acceptRequestRider) {
            try {
                FileWriter fileWriter = new FileWriter("src\\RiderRequest\\"+i.getUsername()+".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);

                printWriter.println(i.getUsername());
                printWriter.println(i.getPassword());
                printWriter.println(i.getAddress());
                printWriter.println(i.getEmail());
                printWriter.println(i.getName());
                printWriter.println(i.getPhoneNumber());

                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception exception)
            {
                System.out.println("Error while writing customer while closeing");
            }
        }

        for(Restaurant j : Restaurant.Restaurants) {
            for(Food i : j.foods ) {
                try {
                    FileWriter fileWriter = new FileWriter("src\\RestaurantFoods\\" + j.getUsername() + ".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                    printWriter.println(i.getFoodItem());
                    printWriter.println(i.getPrice());

                    printWriter.close();
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (Exception exception) {
                    System.out.println("Error while writing customer while closeing");
                }
            }
        }

        for(Rider j  : Rider.Riders) {

                try {
                    FileWriter fileWriter = new FileWriter("src\\BlockList\\" + j.getUsername() + ".txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);
                    printWriter.println(j.getUsername());
                    for(Customer k : j.blockedCustomer) {
                        printWriter.println(k.getUsername());
                    }
                    printWriter.close();
                    bufferedWriter.close();
                    fileWriter.close();

                } catch (Exception exception) {
                    System.out.println("Error while writing customer while closeing");
                }
            }

        System.exit(0);
    }
    public void loginButton(ActionEvent e) throws IOException {
        username = usernameField.getText();
        String password = passwordField.getText();

        Customer c = new Customer();
        boolean flag = c.Login(username,password);
        if(!flag)
        {
            Rider r = new Rider();
            flag = r.Login(username,password);
            if(!flag)
            {
                Restaurant re = new Restaurant();
                flag = re.Login(username, password);
                if(!flag)
                {
                    Admin a = new Admin();
                    flag = a.Login(username,password);
                    if(!flag)
                    {
                        invalidCredentialsLabel.setText("Invalid Credentials");
                    }
                    else {
                        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
                        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
                else
                {
                    Parent root = FXMLLoader.load(getClass().getResource("RestaurantLogin.fxml"));
                    stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
            else
            {
                Parent root = FXMLLoader.load(getClass().getResource("RiderLogin.fxml"));
                stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        else
        {
            Parent root = FXMLLoader.load(getClass().getResource("LoginCustomer.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void backToLoginPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GotoCreateAccountPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void CreateCustomerAccount(ActionEvent e)
    {
       String username=CustomerRegisterUsername.getText();
       String Name=CustomerRegisterName.getText();
       String Password=CustomerRegisterPassword.getText();
       String Address=CustomerRegisterAddress.getText();
       String Email=CustomerRegisterEmail.getText();
        boolean b = false;
        if(Email.contains("@"))
        {
            b = true;
        }
       String PhoneNo=CustomerRegisterPhoneNumber.getText();
        if(b) {
            Customer C = new Customer(username, Password, Name, Email, PhoneNo, Address);
        }
       if(Customer.check || !b)
       {
           CustomerRegisterConfirmationLAbel.setText("Username already Exists or invalid");
       }
       else
       {
           Dialog d = new Alert(Alert.AlertType.INFORMATION);
           d.setContentText("Your account has been created");

           d.show();
       }
        Customer.check = false;
    }
    public void CreateRestaurantAccount(ActionEvent e)
    {
        String username=RestaurantRegisterUsername.getText();
        String password=RestaurantRegisterPassword.getText();
        String name=RestaurantRegisterOwnerName.getText();
        String Email=RestaurantRegisterOwnerEmail.getText();
        boolean b = false;
        if(Email.contains("@"))
        {
            b = true;
        }
        String phoneNumber=RestaurantRegisterOwnerPhoneNumber.getText();
        String address=RestaurantRegisterOwnerAddress.getText();
        String RestaurantName=RestaurantRegisterRestaurantName.getText();
        String RestaurantAddress=RestaurantRegisterOwnerAddress.getText();
        String RestaurantContactNumber=RestaurantRegisterRestaurantContactinfo.getText();
        String RestaurantMail=RestaurantRegisterRestaurantMail.getText();

        if(b) {
            Restaurant R = new Restaurant(username, password, name, Email, phoneNumber, address, RestaurantName, RestaurantAddress, RestaurantContactNumber, RestaurantMail);
        }
        if(Restaurant.check || !b)
        {
            RestaurantRegisterConfirmationLAbel.setText("Username or Restaurant name already Exists or invalid");
        }
        else
        {
            Dialog d = new Alert(Alert.AlertType.INFORMATION);
            d.setContentText("Your account has been given to admin for analysis");
            d.show();
        }
       Restaurant.check = false;
    }

    public void CreateRiderAccount() {
        String username = RiderRegisterUsername.getText();
        String password = RiderRegisterPassword.getText();
        String name = RiderRegisterName.getText();
        String Email = RiderRegisterEmail.getText();
        boolean b = false;
        if(Email.contains("@"))
        {
            b = true;
        }
        String phoneNumber = RiderRegisterPhoneNumber.getText();
        String address = RiderRegisterAddress.getText();
        if (b) {
            Rider r = new Rider(username, password, name, Email, phoneNumber, address);
        }
        if (Rider.check || !b) {
            RiderRegisterConfirmationLAbel.setText("Username already Exists or invalid");
        }
        else {
            Dialog d = new Alert(Alert.AlertType.INFORMATION);
            d.setContentText("Your account has been given to admin for analysis");
            d.show();
        }
        Rider.check = false;
    }

    @FXML
    public void initialize()
    {
        Customer.currentRestaurantCart = "";
    }
}