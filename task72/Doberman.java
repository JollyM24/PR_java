package task72;

public class Doberman extends Dog {
    String name;
    int age;
    String breed;
    int h_age;

    public Doberman(String name, int age){
        this.name = name;
        this.age = age;
        this.breed = "Doberman";
        calcAge();
        System.out.println(toString());
        bark();
        action();
    }

    @Override
    public void calcAge() {
        h_age = age * 7;
    }

    @Override
    public void bark() {
        System.out.println("\"Гав-Гав!\"");
    }

    @Override
    public String toString() {
        return "[DOG] name: " + name +
                "\n      age: " + age + " (" + h_age + ")" +
                "\n      breed: " + breed;
    }

    @Override
    public void action() {
        System.out.println("Feed " + breed + " " + name);
    }
}