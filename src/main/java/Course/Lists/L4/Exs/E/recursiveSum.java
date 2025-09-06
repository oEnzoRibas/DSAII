package Course.Lists.L4.Exs.E;

import java.util.Scanner;

public class recursiveSum {
    public static void main(String[] args) {
        Scanner kIn = new Scanner(System.in);

        System.out.println("Digite a");
        int a = kIn.nextInt();
        System.out.println("Digite b");
        int b = kIn.nextInt();

        System.out.println(sum(a,b));
    }

    static int sum( int a, int b){

        if (b == 0) return 0;
        return b>0 ? a + 1 + sum(0, --b) : a - 1 + sum(0, ++b);
    }
}
