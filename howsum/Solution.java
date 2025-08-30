package win.howsum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static ArrayList<Integer> howSum(int targetSum, int[] num, Map<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (int i = 0; i < num.length; i++) {
            int remainder = targetSum - num[i];
            ArrayList<Integer> remainderResult = howSum(remainder, num, memo);
            if (remainderResult != null) {
                remainderResult.add(num[i]);
                memo.put(targetSum, remainderResult);
                return memo.get(targetSum);
            }

        }
        memo.put(targetSum, null);
        return null;

    }

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[] { 2, 3 }, new HashMap<Integer, ArrayList<Integer>>())); // [3, 2, 2]
        System.out.println(howSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<Integer, ArrayList<Integer>>())); // [4, 3]
        System.out.println(howSum(7, new int[] { 2, 4 }, new HashMap<Integer, ArrayList<Integer>>())); // null
        System.out.println(howSum(8, new int[] { 2, 3, 5 }, new HashMap<Integer, ArrayList<Integer>>())); // [2, 2, 2,
                                                                                                          // 2]
        System.out.println(howSum(300, new int[] { 7, 14 }, new HashMap<Integer, ArrayList<Integer>>())); // null
    }

}
