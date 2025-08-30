package win.bee;

import java.math.BigInteger;

public class Solution {

    public BigInteger beee(int time) {
        BigInteger Q = BigInteger.ONE, s = BigInteger.ZERO, w = BigInteger.ONE;
        for (int i = 0; i < time; i++) {
            BigInteger w1 = w;

            w = Q.add(s).add(w);
            s = w1;
        }

        return Q.add(w).add(s);
    }
}
