package task21_22.task2;

import java.util.Scanner;

public class Main21_2 {
    public static void main(String[] args) {
        Client client = new Client();
    }

    public static class Client implements Chair {
        int choice;
        Chair chair;

        public Client() {
            System.out.println("Виды стульев: \n" +
                    "   1. Викторианский стул;\n" +
                    "   2. Многофункциональный стул;\n" +
                    "   3. Магический стул.\n" +
                    "Ваш выбор: ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();

            switch(choice) {
                case 1:{ Factory victorian_chair = new VictorianFactory();
                    chair = victorian_chair.createChair();
                };
                break;
                case 2:{ Factory mf_chair = new MFFactory();
                    chair = mf_chair.createChair();
                };
                break;
                case 3:{ Factory magic_chair = new MagicFactory();
                    chair = magic_chair.createChair();
                };
                break;
            };

            this.sit();
        }

        @Override
        public void sit() {
            chair.sit();
        }
    }
////////////////////////////////////////////////
    public interface Chair {
      void sit();
    }

    public static class VictorianChair implements  Chair{
        @Override
        public void sit() {
            System.out.println("Клиент выбрал " +
                    "викторианский стул. Клиент сел на викторианский стул.");
        }
    }
    public static class MFChair implements  Chair{
        @Override
        public void sit() {
            System.out.println("Клиент выбрал многофункциональный стул. Клиент сел на многофункциональный стул.");
        }
    }
    public static class MagicChair implements  Chair{
        @Override
        public void sit() {
            System.out.println("Клиент выбрал магический стул. Клиент сел на магический стул.");
        }
    }
////////////////////////////////////////////////
    public interface Factory{
        Chair createChair();
    }

    public static class VictorianFactory implements Factory {
        @Override
        public Chair createChair() {
            return new VictorianChair();
        }
    }
    public static class MFFactory implements Factory {
        @Override
        public Chair createChair() {
            return new MFChair();
        }
    }
    public static class MagicFactory implements Factory {
        @Override
        public Chair createChair() {
            return new MagicChair();
        }
    }
}
