package win.bestSUm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static ArrayList<Integer> bestSum(int targetSum, int[] num, Map<Integer, ArrayList<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        ArrayList<Integer> shortestco = null;
        for (int i = 0; i < num.length; i++) {
            int remainder = targetSum - num[i];
            ArrayList<Integer> remainderResult = bestSum(remainder, num, memo);
            if (remainderResult != null) {
                ArrayList<Integer> combination = new ArrayList<>(remainderResult); // copy list
                combination.add(num[i]);
                if (shortestco == null || combination.size() < shortestco.size()) {
                    shortestco = combination;
                }
            }

        }
        memo.put(targetSum, shortestco);
        return memo.get(targetSum);

    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<Integer, ArrayList<Integer>>())); // [7]
        System.out.println(bestSum(8, new int[] { 2, 3, 5 }, new HashMap<Integer, ArrayList<Integer>>())); // [3, 5]
        System.out.println(bestSum(8, new int[] { 1, 4, 5 }, new HashMap<Integer, ArrayList<Integer>>())); // [4, 4]
        System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 }, new HashMap<Integer, ArrayList<Integer>>())); // [25,
                                                                                                                 // 25,
                                                                                                                 // 25,
                                                                                                                 // 25]
    }

}
