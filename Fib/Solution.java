package win.Fib;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public static BigInteger fib(int n, ArrayList<BigInteger> mamo) {
        if (n <= mamo.size()) {
            return mamo.get(n - 1);
        }
        if (n <= 2) {
            return BigInteger.ONE;
        }
        BigInteger val = fib(n - 1, mamo).add(fib(n - 2, mamo));

        mamo.add(val);
        return mamo.get(n - 1);
    }

    public static void main(String[] args) {
        ArrayList<BigInteger> mamo = new ArrayList<>();
        mamo.add(BigInteger.ONE);
        mamo.add(BigInteger.ONE);
        System.out.println("" + fib(1, mamo));
        System.out.println("" + fib(2, mamo));
        System.out.println("" + fib(50, mamo));
    }
}
