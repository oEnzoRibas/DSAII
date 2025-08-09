package Lists.L1.Exs.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double num;
        Scanner kIn = new Scanner(System.in);

        System.out.println("Write a number");
        num = kIn.nextDouble();
        System.out.println(numSign(num));
    }

    public static String numSign(double n) {
        String result;

        if (n == 0) result = "Zero";
        else if (n < 0) result = "Negative";
        else result = "Positive";
        return "The number is " + result;
    }
}
