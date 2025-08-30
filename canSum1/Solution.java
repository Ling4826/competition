package win.canSum1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean canSum(int targetSum, int[] num) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;
        for (int i = 0; i <= targetSum; i++) {
            if (table[i] == true) {
                for (int j = 0; j < num.length; j++) {
                    if (i + num[j] <= targetSum) {
                        table[i + num[j]] = true;
                    }
                }

            }
        }
        System.out.println(Arrays.toString(table));
        return table[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] { 2, 3 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, new int[] { 2, 4 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(8, new int[] { 2, 3, 5 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(300, new int[] { 7, 14 }, new HashMap<Integer, Boolean>()));
    }

    public static boolean canSum(int targetSum, int[] num, Map<Integer, Boolean> memo) {
        return canSum(targetSum, num);
    }

}
