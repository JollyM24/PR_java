package task8_1;

import java.util.Scanner;

public class Main8_1 {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин мебели");
        FurnitureShop shop = new FurnitureShop();

        shop.add(new Chair("Wooden chair", "brown", 1000.00));
        shop.add(new Table("Wooden table", "dark", 1200.00));
        shop.add(new Sofa("Awesome Sofa", "red", 3500.00));
        shop.add(new Chair("Plastic chair", "white", 1000.00));
        shop.add(new Table("Table for dinner", "cian", 800.00));
        shop.add(new Sofa("Large Sofa", "white", 2000.00));

        shop.showCatalog();

        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        while (choice !=-1) {
            System.out.println("Введите номер мебели для покупки, \"0\" - для вывода каталога, \"-1\" - для выхода");
            choice = scanner.nextInt();
            if (choice == -1) {
                System.out.println("До свидания!");
                return;
            }
            else if (choice == 0) {
                shop.showCatalog();
                System.out.println("Спасибо за покупку!");
            }
            else shop.buy(choice-1);
        }
    }
}
