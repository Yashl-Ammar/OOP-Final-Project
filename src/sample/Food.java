package sample;

public class Food {
    private String FoodItem;
    private double Price;
    Food()
    {
        FoodItem="AbC";
        Price=0.0;
    }
    Food(String FoodItem,double Price)
    {
        this.FoodItem=FoodItem;
        this.Price=Price;
    }

    public void setFoodItem(String foodItem) {
        FoodItem = foodItem;
    }

    public String getFoodItem() {
        return FoodItem;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getPrice() {
        return Price;
    }
}
