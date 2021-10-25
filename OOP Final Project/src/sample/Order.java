package sample;

import java.util.ArrayList;
import java.util.Random;
public class Order {
    Customer c = new Customer();
    Random rand = new Random();
    ArrayList<Food> OrderFood=new ArrayList<Food>();
    private double TotalPrice;
    private String status;
    private String restaurantName;
    private int ordernumber= rand.nextInt(100000);

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }
    public int getOrdernumber() {
        return ordernumber;
    }
    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setOrderFood(ArrayList<Food> orderFood) {
        OrderFood = orderFood;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getC() {
        return c;
    }

    public ArrayList<Food> getOrderFood() {
        return OrderFood;
    }

    public String getStatus() {
        return status;
    }

    public void display() {
        System.out.println("Food items:");
        for (Food i : OrderFood)
        {
            System.out.println(i.getFoodItem());
        }
        System.out.println();
        System.out.println("Total Price : " + getTotalPrice());
        System.out.println("Status of Order: "+getStatus());
    }
}
