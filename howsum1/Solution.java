package win.howsum1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static ArrayList<Integer> howSum(int targetSum, int[] num) {
        ArrayList<Integer>[] table = new ArrayList[targetSum + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<Integer>();
        for (int i = 0; i < targetSum; i++) {
            if (table[i] != null) {
                for (int n : num) {
                    if (i + n <= targetSum) {
                        ArrayList<Integer> combination = new ArrayList<>(table[i]);
                        combination.add(n);
                        table[i + n] = combination;
                    }
                }

            }
        }
        return table[targetSum];

    }

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[] { 2, 3 }, new HashMap<Integer, ArrayList<Integer>>())); // [3, 2, 2]
        System.out.println(howSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<Integer, ArrayList<Integer>>())); // [4, 3]
        System.out.println(howSum(7, new int[] { 2, 4 }, new HashMap<Integer, ArrayList<Integer>>())); // null
        System.out.println(howSum(8, new int[] { 2, 3, 5 }, new HashMap<Integer, ArrayList<Integer>>())); // [2, 2, 2,
        // 2]
        System.out.println(howSum(300, new int[] { 7, 14 }, new HashMap<Integer, ArrayList<Integer>>())); // null
    }

    public static ArrayList<Integer> howSum(int targetSum, int[] num, Map<Integer, ArrayList<Integer>> memo) {
        return howSum(targetSum, num);
    }

}
