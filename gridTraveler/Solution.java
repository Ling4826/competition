package win.gridTraveler;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static long gridTraveler(int m, int n, Map<String, Long> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (n == 0 || m == 0)
            return 0;
        if (n == 1 || m == 1)
            return 1;

        long result = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1, 1, new HashMap<>()));
        System.out.println(gridTraveler(2, 3, new HashMap<>()));
        System.out.println(gridTraveler(3, 2, new HashMap<>()));
        System.out.println(gridTraveler(3, 3, new HashMap<>()));
        System.out.println(gridTraveler(18, 18, new HashMap<>()));

    }
}
