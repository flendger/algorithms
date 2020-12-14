package lesson5;

public class MathPowApp {

    public static void main(String[] args) {
        System.out.println(powOf(5, 4));
    }

    public static long powOf(int x, int n) {
        if (n == 1) return x;

        return x * powOf(x, n - 1);
    }
}
