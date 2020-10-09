package task8_1;

public class Sofa extends Furniture {
    private String name;
    public Sofa(String name, String color, double price) {
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
        return "Диван " + this.getName() + "; цена: " + this.getPrice();
    }
}
