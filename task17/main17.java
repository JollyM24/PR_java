package task17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main17{
    public static void FindPattern(String s, String input){
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(input);
        boolean found = matcher.matches();
        if (found)
            System.out.printf("%s - правильное выражение\n", input);
        else System.out.printf("%s - неправильное выражение\n", input);
        return;
    }

    public static void Test1(){
        String s1 = "abcdefghijklmnopqrstuv18340";
        String s2 = "abcdefghijklmnoasdfasdpqrstuv18340";
        String s = "abcdefghijklmnopqrstuv18340";
        FindPattern(s, s1);
        FindPattern(s, s2);
    }

    public static void Test2(){
        //String regex = "([a-fA-F][a-fA-F]:){3}([0-9][0-9]:){2}[0-9][0-9]";
        String regex = "([a-fA-F][a-fA-F]:){3}([0-9][0-9][:]*){3}";
        String s1 = "aE:dC:cA:56:76:54";
        String s2 = "01:23:45:67:89:Az";

        FindPattern(regex, s1);
        FindPattern(regex, s2);
    }

    public static void Test3(){
        String s = "(\\s*[0-9][0-9]\\.[0-9][0-9]\\s([U][S][D]|[R][U][R]|[E][U])(\\,)*)+";
        String s1 = "23.78 USD, 23.78 RUR, 23.78 EU";
        String s2 = "22 UDD, 0.002 USD";

        FindPattern(s, s1);
        FindPattern(s, s2);
    }

    public static void main(String[] args) {
        Test1();
        System.out.println("////////");
        Test2();
        System.out.println("////////");
        Test3();
    }
  }
