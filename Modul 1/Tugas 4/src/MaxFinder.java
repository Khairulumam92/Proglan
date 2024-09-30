public class MaxFinder {
    public static int findMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        // Pengujian
        System.out.println("Test Find Max Positive: " + (findMax(1, 2, 3) == 3));
        System.out.println("Test Find Max Negative: " + (findMax(-1, -2, -3) == -1));
        System.out.println("Test Find Max With Zero: " + (findMax(0, 0, 1) == 1));
    }
}
