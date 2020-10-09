package task8_1;

public class Chair extends Furniture {
    private String name;
    public Chair(String name, String color, double price) {
        super(color, price);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Стул " + this.getName() + "; цена: " + this.getPrice();
    }
}
