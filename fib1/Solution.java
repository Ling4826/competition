package win.fib1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static BigInteger fib(int n) {
        if (n < 0)
            return BigInteger.ZERO;
        if (n == 0)
            return BigInteger.ZERO;

        BigInteger[] list = new BigInteger[n + 2];
        Arrays.fill(list, BigInteger.ZERO);
        list[1] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            list[i + 1] = list[i + 1].add(list[i]);

            if (i + 2 < list.length) {
                list[i + 2] = list[i + 2].add(list[i]);
            }
        }
        return list[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci of 6: " + fib(6)); // Output: 8
        System.out.println("Fibonacci of 7: " + fib(7)); // Output: 13
        System.out.println("Fibonacci of 8: " + fib(8)); // Output
        System.out.println("Fibonacci of 50: " + fib(50)); // Output
    }
}
