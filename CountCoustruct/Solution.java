package win.CountCoustruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return 1;
        }
        int totalCount = 0;
        for (int i = 0; i < wordBank.length; i++) {
            if (target.indexOf(wordBank[i]) == 0) {
                String suffix = target.substring(wordBank[i].length());
                int numway = countConstruct(suffix, wordBank, memo);
                totalCount += numway;
            }

        }
        memo.put(target, totalCount);
        return totalCount;

    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" })); // -> 2
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); // -> 1
        System.out.println(countConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // ->
                                                                                                                        // 0
        System.out
                .println(countConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); // ->
                                                                                                                        // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" })); // -> 0
    }

    public static int countConstruct(String target, String[] wordBank) {
        return countConstruct(target, wordBank, new HashMap<>());
    }

}