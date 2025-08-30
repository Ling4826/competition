package win.allCoustruct1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        // table[i] = list ของวิธีการสร้าง target.substring(0, i)
        List<List<List<String>>> table = new ArrayList<>();

        // init table (แต่ละ index เป็น list ว่าง)
        for (int i = 0; i <= target.length(); i++) {
            table.add(new ArrayList<>());
        }

        // base case: วิธีสร้าง "" คือ [[]]
        table.get(0).add(new ArrayList<>());

        for (int i = 0; i <= target.length(); i++) {
            for (String word : wordBank) {
                if (i + word.length() <= target.length() &&
                        target.substring(i, i + word.length()).equals(word)) {

                    // copy combinations ที่มีอยู่ใน table[i]
                    for (List<String> subList : table.get(i)) {
                        List<String> newCombination = new ArrayList<>(subList);
                        newCombination.add(word);
                        table.get(i + word.length()).add(newCombination);
                    }
                }
            }
        }

        return table.get(target.length());
    }

    public static void main(String[] args) {
        System.out.println("Result for 'purple':");
        System.out.println(allConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        // Expected: [[purp, le], [p, ur, p, le]]

        System.out.println("\nResult for 'abcdef':");
        System.out.println(allConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" }));
        // Expected: [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]

        System.out.println("\nResult for 'skateboard':");
        System.out.println(allConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
        // Expected: []

        System.out.println("\nResult for 'aaaaaaaa...z':");
        System.out.println(
                allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[] { "a", "aa", "aaa", "aaaa", "aaaaa" }));
        // Expected: []
    }

}
