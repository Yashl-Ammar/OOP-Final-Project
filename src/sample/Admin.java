package sample;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person {
    static ArrayList<Admin> Admins=new ArrayList<Admin>();

    static ArrayList<Restaurant> acceptRequestRestaurants = new ArrayList<Restaurant>();
    static ArrayList<Rider> acceptRequestRider=new ArrayList<Rider>();

    Admin() {
        super();
    }
    Admin(String username, String password, String name, String Email, String phoneNumber, String address) // Creating Account
    {
        super(username,password,name,Email,phoneNumber,address);
        boolean check = false;
        for (Customer i : Customer.Customers) {
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
            Admins.add(this);
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
    @Override
    public Boolean Login(String username,String password)
    {
        Boolean B=false;
        for(Admin i: Admins)
        {
            if(username.equals(i.getUsername()) && password.equals(i.getPassword()))
            {
                B=true;
            }
        }
        return B;
    }
    public void manageVendors(String username) {
        for (Admin i : Admins) {
            if (i.getUsername().equals(username)) {

            }
        }
    }
    public void manageFood()
    {

    }

}