package win.Catalan14;

import java.util.ArrayList;

public class Activity1 {
    public static void main(String[] args) {
        int n = 3;

        long startRec = System.nanoTime();
        int resultRec = catalanRecursive(n);
        long endRec = System.nanoTime();
        System.out.println("Recursive Result: " + resultRec);
        System.out.println("Recursive Time: " + (endRec - startRec) / 1_000_000.0 + " ms");
    }

    public static int catalanRecursive(int n) {
        if (n <= 1)
            return 1;

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalanRecursive(i) * catalanRecursive(n - 1 - i);
        }
        return res;
    }

}
