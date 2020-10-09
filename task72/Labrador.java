package task72;

public class Labrador extends Dog{
        String name;
        int age;
        String breed;
        int h_age;

        public Labrador(String name, int age){
            this.name = name;
            this.age = age;
            this.breed = "Labrador";
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
            System.out.println("\"Гав-Гав-Гав!\"");
        }

        @Override
        public String toString() {
            return "[DOG] name: " + name +
                    "\n      age: " + age + " (" + h_age + ")" +
                    "\n      breed: " + breed;
        }

    @Override
    public void action() {
        System.out.println("Care for " + breed + " " + name);
    }
    }
