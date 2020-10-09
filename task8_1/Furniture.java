package task8_1;

public abstract class Furniture {
    double price;
    String color;

    public Furniture(String color, double price){
        this.color = color;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getColor() {
        return color;
    }

    public abstract String toString();
}
