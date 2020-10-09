package task8_1;

public class Table extends Furniture {
    private String name;
    public Table(String name, String color, double price) {
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
        return "Стол " + this.getName() + "; цена: " + this.getPrice();
    }
}
