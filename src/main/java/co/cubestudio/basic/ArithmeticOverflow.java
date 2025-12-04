package co.cubestudio.basic;

public class ArithmeticOverflow {
    public static void main(String[] args) {
        for (int n = 0; n >= 0; n++);
        System.out.println("Overflow detected");

        int x = Integer.MAX_VALUE;
        int y = (x + 1);

        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }
}
