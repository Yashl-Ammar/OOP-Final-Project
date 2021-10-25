package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {



    static boolean check = false;
    static  int counter=1;
    static ArrayList<Customer> Customers = new ArrayList<Customer>();
    ArrayList<Order> Orderhistory=new ArrayList<Order>();
    static String currentRestaurantCart = "";
    ArrayList<Food> Cart =new ArrayList<Food>();
    Customer()
    {
        super();
    }
    public void viewFoodDetail(String username) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Restaurants List");
        for (Restaurant i : Restaurant.Restaurants) {
            TableColumn T=new TableColumn();
            System.out.println("Press " + counter + " to see the menu of " + i.getRestaurantName());
            counter++;
        }
        System.out.println("Press 0 to go to main menu");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice!=0)
        {
            while (choice < 0 || choice > (counter - 1)) {
                System.out.println("Press Valid Choice: ");
                choice = sc.nextInt();
                sc.nextLine();
            }
            counter = 1;
            System.out.println("Food List:");
            for (Food i : Restaurant.Restaurants.get(choice - 1).foods)
            {
                System.out.println("Press " + counter + " to add " + i.getFoodItem() + "in cart" + "----------" + i.getPrice() + "/-");
                counter++;
            }
            System.out.println("Press 0 to go to main menu");
            System.out.println("Enter choice : ");
            int choice1 = sc.nextInt();
            sc.nextLine();
            while (choice1 < 0 || choice1 > (counter - 1)) {
                System.out.println("Press Valid Choice: ");
                choice1 = sc.nextInt();
                sc.nextLine();
            }

            addToCart(Restaurant.Restaurants.get(choice-1).foods.get(choice1-1),username,Restaurant.Restaurants.get(choice-1).getRestaurantName());

       }
        else if(choice==0)
        {
            System.out.println("Invalid Choice");
        }
    }
    Customer(String username, String password, String name, String Email, String phoneNumber, String address) // Creating Account
    {
        super(username, password, name, Email, phoneNumber, address);

        for (Customer i : Customers) {
            if (username.equals(i.getUsername())) {
                System.out.println("Invalid username it already exists");
                check = true;
            }
        }
        for (Restaurant i : Restaurant.Restaurants) {
            if (username.equals(i.getUsername())) {
                System.out.println("Invalid username it already exists");
                check = true;
            }
        }
        for (Rider i : Rider.Riders)
        {
            if (username.equals(i.getUsername())) {
                System.out.println("Invalid username it already exists");
                check = true;
            }
        }
        for(Admin i : Admin.Admins)
        {
            if (username.equals(i.getUsername())) {
                System.out.println("Invalid username it already exists");
                check = true;
            }
        }
        for(Restaurant i: Admin.acceptRequestRestaurants)
        {
            if (username.equals(i.getUsername())) {
                System.out.println("Invalid username it already exists");
                check = true;
            }
        }
        if(!check) {
            Customers.add(this);
        }
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }
    public Boolean addToCart(Food temp,String username, String restaurantName)
    {
        Boolean b = false;
        if(currentRestaurantCart.equals("") || currentRestaurantCart.equals(restaurantName)) {
            for (Customer i : Customers) {
                if (username.equals(i.getUsername())) {
                    i.Cart.add(temp);
                    b = true;
                    currentRestaurantCart = restaurantName;
                }
            }
            if (!b) {
                System.out.println("Unable to add to cart");
            }
        }
        else
        {
            System.out.println("You can't add to cart from another restaurant");
        }
      return b;
    }

    public boolean placeOrder(String username)
    {

        boolean b = false;
        Order temp=new Order();
        temp.setStatus("Placed");
        for(Customer j: Customers)
        {
            if(username.equals(j.getUsername()))
            {
                if(j.Cart.size()==0)
                {
                    b = true;
                    break;
                }
                temp.c = j;
                for (Food i : j.Cart)
                {
                    temp.setTotalPrice(temp.getTotalPrice()+ i.getPrice());
                    temp.OrderFood.add(i);
                }
            }
        }

        for(Restaurant i : Restaurant.Restaurants)
        {
            if(i.getRestaurantName().equals(currentRestaurantCart))
            {
                i.OrderList.add(temp);
            }
        }

        return b;
    }
    public Boolean cancelOrder(String username)
    {
        Boolean B=false;
        for(Customer i : Customers)
        {
            if(username.equals(i.getUsername()))
            {
                for(Restaurant j : Restaurant.Restaurants)
                {
                    for(Order k : j.OrderList)
                    {
                        if(username.equals(k.c.getUsername()))
                        {
                            j.OrderList.remove(k);
                            B=true;
                            break;
                        }
                    }
                }

                for(Order j : Rider.RidersOrder)
                {
                    if(username.equals(j.c.getUsername()))
                    {
                        Rider.RidersOrder.remove(j);
                        B=true;
                        break;
                    }
                }

                for(Rider j : Rider.Riders)
                {
                    if(j.Acceptorder.c.getUsername().equals(username))
                    {
                        Customer c = new Customer();
                        Order tempo = new Order();
                        j.Acceptorder.setC(c);
                        j.Acceptorder.setOrderFood(tempo.getOrderFood());
                        j.Acceptorder.setOrdernumber(0);
                        j.Acceptorder.setTotalPrice(tempo.getTotalPrice());
                        B=true;
                        break;
                    }
                }
            }
        }
        return B;
    }

    public String CheckDeliveryStatus(String username)
    {
        String temp = "";
        Boolean B= false ;
        for(Customer i : Customers)
        {
            if(username.equals(i.getUsername()))
            {
                for(Restaurant j : Restaurant.Restaurants)
                {
                    for(Order k : j.OrderList)
                    {
                        if(username.equals(k.c.getUsername()))
                        {

                            temp = "Your Delivery Status is:  "+k.getStatus();
                            B=true;
                            break;
                        }
                    }
                }

                for(Order k : Rider.RidersOrder)
                {
                    if(username.equals(k.c.getUsername()))
                    {

                        temp = "Your Delivery Status is:  "+k.getStatus();
                        B=true;
                        break;
                    }
                }

                for(Rider j : Rider.Riders)
                {
                    if(j.Acceptorder.c.getUsername().equals(username))
                    {

                        temp = "Your Delivery Status is:  "+j.Acceptorder.getStatus();
                        B=true;
                        break;
                    }
                }


            }
        }
        if(!B)
        {
            temp = "No Order!! placed with your Account ";
        }
        return  temp;
    }
    @Override
    public Boolean Login(String username,String password)
    {
        Boolean B=false;
       for(Customer i: Customers)
       {
           if(username.equals(i.getUsername()) && password.equals(i.getPassword()))
           {
               B=true;
           }
       }

       return B;
    }

}