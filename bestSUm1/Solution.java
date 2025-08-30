package win.bestSUm1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static ArrayList<Integer> bestSum(int targetSum, int[] num) {
        ArrayList<Integer>[] table = new ArrayList[targetSum + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<>();
        for (int i = 0; i < targetSum; i++) {
            if (table[i] != null) {
                for (int j = 0; j < num.length; j++) {
                    if (i + num[j] <= targetSum) {
                        ArrayList<Integer> re = new ArrayList<>(table[i]);
                        re.add(num[j]);
                        if (table[i + num[j]] == null || table[i + num[j]].size() > re.size())
                            table[i + num[j]] = re;
                    }
                }
            }
        }
        return table[targetSum];

    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 }, new HashMap<Integer, ArrayList<Integer>>())); // [7]
        System.out.println(bestSum(8, new int[] { 2, 3, 5 }, new HashMap<Integer, ArrayList<Integer>>())); // [3, 5]
        System.out.println(bestSum(8, new int[] { 1, 4, 5 }, new HashMap<Integer, ArrayList<Integer>>())); // [4, 4]
        System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 }, new HashMap<Integer, ArrayList<Integer>>())); // [25,
                                                                                                                 // 25,
                                                                                                                 // 25,
                                                                                                                 // 25]

        System.out.println(bestSum(100, new int[] { 25, 1, 2, 5 }, new HashMap<Integer, ArrayList<Integer>>()));
    }

    public static ArrayList<Integer> bestSum(int targetSum, int[] num, Map<Integer, ArrayList<Integer>> memo) {
        return bestSum(targetSum, num);
    }

}
