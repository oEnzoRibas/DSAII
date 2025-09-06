package Course.Lists.L4.Exs.C;

public class recursiveDivider {
    public static void main(String[] args) {
        System.out.println(divide(31,5));
    }
    public static int divide(int a, int b){
        if (a < b) return 0;
        return 1 + divide(a-b, b);
    }
}
