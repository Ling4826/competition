package win.canCoustruct1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Lad.eleven.readflie;

class Solution {
    public static Boolean canConstruct(String target, String[] wordBank) {
        Boolean[] table = new Boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if (table[i] != false) {
                for (int j = 0; j < wordBank.length; j++) {
                    if (i + wordBank[j].length() <= target.length() &&
                            target.substring(i, i + wordBank[j].length()).equals(wordBank[j])) {

                        if (i + wordBank[j].length() < table.length) {
                            table[i + wordBank[j].length()] = true;
                        }
                    }
                }

            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" },
                new HashMap<>())); // true
        System.out.println(canConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" },
                new HashMap<>())); // false
        System.out.println(canConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" },
                new HashMap<>())); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee" }, new HashMap<>())); // false
    }

    static Boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
        return canConstruct(target, wordBank);
    }
}
