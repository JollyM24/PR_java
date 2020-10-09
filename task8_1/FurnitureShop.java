package task8_1;


import java.util.ArrayList;

public class FurnitureShop {
    ArrayList<Furniture> furn = new ArrayList<>();

    public void add(Furniture furn) {
        this.furn.add(furn);
    }

    public void buy(int item) {
        System.out.println("Вы купили " + furn.get(item).toString());
        furn.remove(furn.get(item));
    }

    public void showCatalog() {
        System.out.println("Каталог: ");
        int i = 1;
        for (Furniture f : furn) {
            System.out.println(i++ + ": " + f.toString());
        }
    }
}

