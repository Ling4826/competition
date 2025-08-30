package win.canSum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean canSum(int targetSum, int[] num, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int i = 0; i < num.length; i++) {
            int remainder = targetSum - num[i];
            if (canSum(remainder, num, memo) == true) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;

    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] { 2, 3 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, new int[] { 2, 4 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(8, new int[] { 2, 3, 5 }, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(300, new int[] { 7, 14 }, new HashMap<Integer, Boolean>()));
    }

}
