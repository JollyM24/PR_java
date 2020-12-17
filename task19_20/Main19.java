package task19_20;

import java.util.*;

public class Main19 {
    public static void main(String[] args) {
        GeneratingNumbers Numbers = new GeneratingNumbers();
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
        Numbers.findNumber(number);
    }

    public static class GeneratingNumbers {
        ArrayList<String> array_number = new ArrayList<>();
        HashSet<String> hash_number = new HashSet<>();
        TreeSet<String> tree_number = new TreeSet<>();
        String number;

        public GeneratingNumbers() {
            String[] Letter = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
            for (int N = 0; N < 10; N++) {
                for (int R = 1; R < 200; R++) {
                    for (String a1 : Letter) {
                        for (String a2 : Letter) {
                            for (String a3 : Letter) {
                                String num = a1 + (N) + (N) + (N) + a2 + a3;
                                if (R < 10) num += "0";
                                num += (R);
                                array_number.add(num);
                                hash_number.add(num);
                                tree_number.add(num);
                            }
                        }
                    }
                }
            }
        }

        public void findNumber(String number){
            long start, end;
            boolean f;
            this.number = number;

            System.out.println("Поиск номера " + number + ":");

            System.out.println("Прямой перебор по ArrayList: ");
            start = System.nanoTime();
            f = array_number.contains(number);
            end = System.nanoTime();
            if (f) System.out.println("Номер найден за " + (end - start) + " нс");
            else System.out.println("Номер не найден");

            Collections.sort(array_number);
            System.out.println("Бинарный поиск по сортированному ArrayList: ");
            start = System.nanoTime();
            f = Collections.binarySearch(array_number, number) >0;
            end = System.nanoTime();
            if (f) System.out.println("Номер найден за " + (end - start) + " нс");
            else System.out.println("Номер не найден");

            System.out.println("Поиск в HashSet: ");
            start = System.nanoTime();
            f = hash_number.contains(number);
            end = System.nanoTime();
            if (f) System.out.println("Номер найден за " + (end - start) + " нс");
            else System.out.println("Номер не найден");

            System.out.println("Поиск в TreeSet: ");
            start = System.nanoTime();
            f = tree_number.contains(number);
            end = System.nanoTime();
            if (f) System.out.println("Номер найден за " + (end - start) + " нс");
            else System.out.println("Номер не найден");
        }
    }
}
