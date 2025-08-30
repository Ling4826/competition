package win.canCoustruct;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static Boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return true;
        }
        for (int i = 0; i < wordBank.length; i++) {
            if (target.indexOf(wordBank[i]) == 0) {
                String suffix = target.substring(wordBank[i].length());
                if (canConstruct(suffix, wordBank, memo) == true) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;

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
}
