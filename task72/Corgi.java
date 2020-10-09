package task72;

public class Corgi extends Dog {
    String name;
    int age;
    String breed;
    int h_age;

    public Corgi(String name, int age){
        this.name = name;
        this.age = age;
        this.breed = "Corgi";
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
        System.out.println("\"Гав!\"");
    }

    @Override
    public String toString() {
        return "[DOG] name: " + name +
                "\n      age: " + age + " (" + h_age + ")" +
                "\n      breed: " + breed;
    }

    @Override
    public void action() {
        System.out.println("To play with " + breed + " " + name);
    }
}
