package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class Rider extends Person {

    static boolean check = false;
    Order Acceptorder=new Order();
    static ArrayList<Rider> Riders = new ArrayList<Rider>();
    static ArrayList<Order> RidersOrder=new ArrayList<Order>();
    ArrayList<Customer> blockedCustomer = new ArrayList<Customer>();
    double CashCollected;
    Rider()
    {
        super();
    }
    Rider(String username, String password, String name, String Email, String phoneNumber, String address) // Creating Account
    {
        super(username,password,name,Email,phoneNumber,address);

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
            Admin.acceptRequestRider.add(this);
        }
    }

    public void setCashCollected(double cashCollected) {
        CashCollected = cashCollected;
    }

    public double getCashCollected() {
        return CashCollected;
    }

    public void setAcceptorder(Order acceptorder) {
        Acceptorder = acceptorder;
    }

    public Order getAcceptorder() {
        return Acceptorder;
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
        for(Rider i: Riders)
        {
            if(username.equals(i.getUsername()) && password.equals(i.getPassword()))
            {
                B=true;
            }
        }
        return B;
    }
    public void viewOrder(String username)
    {
                        for (Order k: RidersOrder)
                        {
                            System.out.println("Customer Name: "+k.c.getName());
                            System.out.println("Customer Address: "+k.c.getAddress());
                            System.out.println("Customer Phone NUmber: "+k.c.getPhoneNumber());
                            System.out.println("Status of food is: "+k.getStatus());
                            for (Food l: k.OrderFood)
                            {
                                System.out.println("Name of food Is: "+l.getFoodItem());
                                System.out.println("Price of Food Is:"+l.getPrice());
                            }
                            System.out.println("Total Price: "+k.getTotalPrice());
                            System.out.println();
                        }
    }
    public void AcceptOrRejectOrder(String username)
    {
        Scanner sc=new Scanner(System.in);
        int counter=1;

        for(Rider i: Riders)
        {
            if(username.equals(i.getUsername()))
            {
              for(Order j: RidersOrder)
              {
                  System.out.println("Press "+counter+" to Accept the Order of this Address: "+j.c.getAddress());
                  j.setStatus("Rider is On his Way to Deliver You");
                  counter++;
              }
              System.out.println("Enter Your Choice: ");
              int choice=sc.nextInt();
              sc.nextLine();
              while(choice <1 || choice> counter-1)
              {
                  System.out.println("Enter a valid Choice: ");
                  choice=sc.nextInt();
                  sc.nextLine();
              }
              i.Acceptorder=Rider.RidersOrder.get(choice);
              Rider.RidersOrder.remove(choice);
            }
        }
    }

    public void updateFoodDeliveryOption(String username)
    {

        for(Rider i : Riders)
        {
            if(username.equals(i.getUsername()))
            {
                for(Customer j: Customer.Customers)
                {
                    if(j.getEmail().equals(i.Acceptorder.c.getEmail()))
                    {
                          for(Order k: j.Orderhistory)
                          {
                              if(k.getOrdernumber()==i.Acceptorder.getOrdernumber())
                              {
                                  k.setStatus("Food has been Delivered");
                                  i.cashCollectionUpdate(i.Acceptorder.getTotalPrice());
                                  i.Acceptorder=null;

                                  break;
                              }
                          }
                    }
                }
            }
        }
    }

    public void cashCollectionUpdate(double TotalPrice)
    {
        CashCollected += TotalPrice;
    }

}