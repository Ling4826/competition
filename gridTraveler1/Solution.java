package win.gridTraveler1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static BigInteger gridTraveler(int m, int n) {
        BigInteger[][] list = new BigInteger[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                list[i][j] = BigInteger.ZERO;
            }
        }
        list[1][1] = BigInteger.ONE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                BigInteger current = list[i][j];
                if (j + 1 <= n) {
                    list[i][j + 1] = list[i][j + 1].add(current);
                }
                if (i + 1 <= m) {
                    list[i + 1][j] = list[i + 1][j].add(current);
                }
            }
        }

        return list[m][n];
    }

    public static BigInteger gridTraveler(int m, int n, Map<String, BigInteger> memo) {
        return gridTraveler(m, n);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1, new HashMap<>())); // 1
        System.out.println(gridTraveler(2, 3, new HashMap<>())); // 3
        System.out.println(gridTraveler(3, 2, new HashMap<>())); // 3
        System.out.println(gridTraveler(3, 3, new HashMap<>())); // 6
        System.out.println(gridTraveler(18, 18, new HashMap<>())); // ค่าใหญ่
    }

}
