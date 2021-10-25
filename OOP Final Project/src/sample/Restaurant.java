package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant extends Person {

    static boolean check = false;

    private String RestaurantName;
    private String RestaurantAddress;
    private String RestaurantContactNumber;
    private String RestaurantMail;
    private int counter=0;
    static ArrayList<Restaurant> Restaurants=new ArrayList<Restaurant>();
    ArrayList<Food> foods=new ArrayList<Food>();
    ArrayList<Order> OrderList=new ArrayList<Order>();
    Restaurant()
    {
        super();
    }

    Restaurant(String username, String password, String name, String Email, String phoneNumber, String address,String RestaurantName,String RestaurantAddress,String RestaurantContactNumber,String RestaurantMail)
    {
        super(username,password,name,Email,phoneNumber,address);
        this.RestaurantAddress=RestaurantAddress;
        this.RestaurantContactNumber=RestaurantContactNumber;
        this.RestaurantMail=RestaurantMail;
        this.RestaurantName=RestaurantName;

        for(Restaurant i : Restaurant.Restaurants)
        {
            if(i.getRestaurantName().equals(RestaurantName))
            {
                check = true;
                break;
            }
        }

        for (Customer i : Customer.Customers) {
            if (username.equals(i.getUsername())) {

                check = true;
            }
        }
        for (Restaurant i : Restaurant.Restaurants) {
            if (username.equals(i.getUsername())) {
                check = true;
            }
        }
        for (Rider i : Rider.Riders)
        {
            if (username.equals(i.getUsername())) {
                check = true;
            }
        }
        for(Admin i : Admin.Admins)
        {
            if (username.equals(i.getUsername())) {
                check = true;
            }
        }
        for(Restaurant i: Admin.acceptRequestRestaurants)
        {
            if (username.equals(i.getUsername())) {
                check = true;
            }
        }
        if(!check) {
            Admin.acceptRequestRestaurants.add(this);
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
    public void setRestaurantAddress(String restaurantAddress) {
        RestaurantAddress = restaurantAddress;
    }

    public String getRestaurantAddress() {
        return RestaurantAddress;
    }

    public void setRestaurantContactNumber(String restaurantContactNumber) {
        RestaurantContactNumber = restaurantContactNumber;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public String getRestaurantContactNumber() {
        return RestaurantContactNumber;
    }

    public void setRestaurantMail(String restaurantMail) {
        RestaurantMail = restaurantMail;
    }

    public String getRestaurantMail() {
        return RestaurantMail;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }
    @Override
    public Boolean Login(String username,String password)
    {
        Boolean B=false;
        for(Restaurant i: Restaurants)
        {
            if(username.equals(i.getUsername()) && password.equals(i.getPassword()))
            {
                B=true;
            }
        }
        return B;
    }

    public Boolean AddFoodDetail(String itemName, double price, String username)
    {
        Boolean B=false;

        for(Restaurant i: Restaurants)
        {
            if(username.equals(i.getUsername()))
            {
                for (Food k: i.foods) {
                    if(itemName.equals(k.getFoodItem()))
                    {
                        B=true;
                        break;
                    }
                }
                if(!B) {
                    if (i.getCounter() <= 15) {
                        Food temp = new Food(itemName, price);
                        i.setCounter(i.getCounter() + 1);

                        i.foods.add(temp);
                        B = false;
                    } else {
                        B = true;
                    }
                }
            }
        }

        return B;
    }

    public Boolean UpdateFoodDetails(String itemName, String username)
    {
        Boolean B=false;
        int choice;
        for(Restaurant i: Restaurants)
        {
            if(username.equals(i.getUsername()))
            {
                for(Food j: i.foods)
                {
                    if(j.getFoodItem().equals(itemName)) {
                        B = true;
                        break;
                    }
                }
            }
        }
        return B;
    }
    public Boolean DeleteFood(String itemName, String username)
    {
        Boolean B=false;
        for(Restaurant i: Restaurants)
        {
            if(username.equals(i.getUsername()))
            {
                for(Food j: i.foods) {
                    if (j.getFoodItem().equals(itemName)) {
                        i.foods.remove(j);

                        i.setCounter(i.getCounter() - 1);
                        B = true;
                        break;
                    }
                }
            }

        }
       return B;
    }
    public void CheckFoodOrder(String username)
    {
        for(Restaurant i: Restaurants ) {
            if (username.equals(i.getUsername())) {
                for (Order j : i.OrderList) {
                    j.display();
                }
            }
        }
    }
    public void CalculateBills(String username)
    {
        for (Restaurant i : Restaurants) {
            if(username.equals(i.getUsername()))
            {
                for (Order j:i.OrderList)
                {
                    for (Food k: j.OrderFood) {
                        System.out.println("Food Item: "+k.getFoodItem());
                        System.out.println("Price of Food: "+k.getPrice());
                    }
                    System.out.println("Total Price of this Order: "+j.getTotalPrice());
                    System.out.println();
                }
            }
        }
    }

}
