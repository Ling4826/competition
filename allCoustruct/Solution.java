package win.allCoustruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static String[][] allCoustruct(String target, String[] wordBank, Map<String, String[][]> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return new String[][] { {} };
        }
        String[][] result = new String[0][0];
        for (int i = 0; i < wordBank.length; i++) {
            if (target.indexOf(wordBank[i]) == 0) {
                String suffix = target.substring(wordBank[i].length());
                String[][] suffixWay = allCoustruct(suffix, wordBank, memo);
                String[][] targetWay = new String[suffixWay.length][];
                for (int j = 0; j < suffixWay.length; j++) {
                    targetWay[j] = new String[suffixWay[j].length + 1];
                    targetWay[j][0] = wordBank[i];
                    for (int k = 0; k < suffixWay[j].length; k++) {
                        targetWay[j][k + 1] = suffixWay[j][k];
                    }
                }
                result = concat(result, targetWay);
            }
        }
        memo.put(target, result);
        return result;
    }

    private static String[][] concat(String[][] a, String[][] b) {
        String[][] result = new String[a.length + b.length][];
        System.arraycopy(a, 0, result, 0, a.length); // copy ของเดิมจาก a
        System.arraycopy(b, 0, result, a.length, b.length); // copy ของใหม่จาก b ต่อท้าย
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result for 'purple':");
        System.out.println(Arrays.deepToString(
                allCoustruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" })));
        // Expected: [[purp, le], [p, ur, p, le]]

        System.out.println("\nResult for 'abcdef':");
        System.out.println(Arrays.deepToString(
                allCoustruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" })));
        // Expected: [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]

        System.out.println("\nResult for 'skateboard':");
        System.out.println(Arrays.deepToString(
                allCoustruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })));
        // Expected: []

        System.out.println("\nResult for 'aaaaaaaa...z':");
        System.out.println(Arrays.deepToString(
                allCoustruct("aaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[] { "a", "aa", "aaa", "aaaa", "aaaaa" })));
        // Expected: []
    }

    public static String[][] allCoustruct(String target, String[] wordBank) {
        return allCoustruct(target, wordBank, new HashMap<>());
    }

}
