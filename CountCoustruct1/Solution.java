package win.CountCoustruct1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int countConstruct(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i] != 0) {
                for (int j = 0; j < wordBank.length; j++) {
                    if (i + wordBank[j].length() <= target.length() &&
                            target.substring(i, i + wordBank[j].length()).equals(wordBank[j])) {
                        if (i + wordBank[j].length() < table.length) {
                            table[i + wordBank[j].length()] += table[i];
                        }
                    }
                }

            }

        }
        return table[target.length()];
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

}