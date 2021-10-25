package sample;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class Main extends Application {
    Admin AD=new Admin("yashlAmmar","admin","Yashl Ammar","yashlammar2561@gmail.com","03145426711","I-8,Islamabad");
    Admin AD1=new Admin("saadsheikh2561","admin","SHEIKH MUHAMMAD SAAD","saadamin2561@gmail.com","03345750840","Gulzar e Quaid,Rawalpindi");
    private double xOffset = 0 ;
    private double yOffset = 0 ;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);
        primaryStage.setScene(new Scene(root, 640, 586));
        primaryStage.show();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                primaryStage.setX(mouseEvent.getScreenX() - xOffset);
                primaryStage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });

    }


    public static void main(String[] args) {

        File file1 = new File("src\\Customer");
        File [] allfileNames = file1.listFiles();

        for(File i : allfileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String username = bufferedReader.readLine();
                String password = bufferedReader.readLine();
                String address= bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String name = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();

                Customer temp = new Customer(username,password,name,email,phoneNumber,address);

                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }

        File file2 = new File("src\\Rider");
        File [] allRiderFileNames = file2.listFiles();

        for(File i : allRiderFileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String username = bufferedReader.readLine();
                String password = bufferedReader.readLine();
                String address= bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String name = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();

                Rider temp = new Rider();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setAddress(address);
                temp.setEmail(email);
                temp.setName(name);
                temp.setPhoneNumber(phoneNumber);

                Rider.Riders.add(temp);

                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }

        File file3 = new File("src\\Restaurant");
        File [] allRestaurantFileNames = file3.listFiles();

        for(File i : allRestaurantFileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String username = bufferedReader.readLine();
                String password = bufferedReader.readLine();
                String address= bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String name = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();
                String restaurantAddress = bufferedReader.readLine();
                String restaurantContactNumber = bufferedReader.readLine();
                String restaurantEmail = bufferedReader.readLine();
                String restaurantName = bufferedReader.readLine();


                Restaurant temp = new Restaurant();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setAddress(address);
                temp.setEmail(email);
                temp.setName(name);
                temp.setPhoneNumber(phoneNumber);
                temp.setRestaurantAddress(restaurantAddress);
                temp.setRestaurantContactNumber(restaurantContactNumber);
                temp.setRestaurantMail(restaurantEmail);
                temp.setRestaurantName(restaurantName);

                Restaurant.Restaurants.add(temp);

                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }

        File file4 = new File("src\\RestaurantFoods");
        File [] allRestaurantFoodFileNames = file4.listFiles();


        for(File i : allRestaurantFoodFileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                for(Restaurant j : Restaurant.Restaurants)
                {
                    String tempo = i.getName().replace(".txt","");
                    if(tempo.equals(j.getUsername()))
                    {
                        String x = bufferedReader.readLine();
                        while (x != null)
                        {
                            String foodName = x;
                            x = bufferedReader.readLine();
                            Food tempfood = new Food(foodName,Double.parseDouble(x));
                            j.foods.add(tempfood);
                            x= bufferedReader.readLine();
                        }
                    }
                }

                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }

        File file5 = new File("src\\RestaurantRequest");
        File [] allRestaurantRequestFileNames = file5.listFiles();

        for(File i : allRestaurantRequestFileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String username = bufferedReader.readLine();
                String password = bufferedReader.readLine();
                String address= bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String name = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();
                String restaurantAddress = bufferedReader.readLine();
                String restaurantContactNumber = bufferedReader.readLine();
                String restaurantEmail = bufferedReader.readLine();
                String restaurantName = bufferedReader.readLine();


                Restaurant temp = new Restaurant(username,password,name,email,phoneNumber,address,restaurantName,restaurantAddress,restaurantContactNumber,restaurantEmail);

                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }

        File file6 = new File("src\\RiderRequest");
        File [] allRiderRequestFileNames = file6.listFiles();

        for(File i : allRiderRequestFileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String username = bufferedReader.readLine();
                String password = bufferedReader.readLine();
                String address= bufferedReader.readLine();
                String email = bufferedReader.readLine();
                String name = bufferedReader.readLine();
                String phoneNumber = bufferedReader.readLine();

                Rider temp = new Rider(username,password,name,email,phoneNumber,address);

                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }

        File file7 = new File("src\\BlockList");
        File [] allRiderBlockListFileNames = file7.listFiles();

        for(File i : allRiderBlockListFileNames)
        {
            try {
                FileReader fileReader = new FileReader(i);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String username = bufferedReader.readLine();

                for(Rider j : Rider.Riders)
                {
                    if(j.getUsername().equals(username))
                    {
                        while (username != null)
                        {
                            username = bufferedReader.readLine();
                            for(Customer k : Customer.Customers)
                            {
                                    if(k.getUsername().equals(username))
                                    {
                                        j.blockedCustomer.add(k);
                                        break;
                                    }
                            }
                        }
                    }
                }




                bufferedReader.close();
                fileReader.close();
            }catch (Exception exception)
            {
                System.out.println("Error while reading the customer files");
            }
        }



        launch(args);
    }
}