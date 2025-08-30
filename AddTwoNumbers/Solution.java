package win.AddTwoNumbers;

import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String A = makeListNode(l1).add(makeListNode(l2)).toString();
        ListNode dummy = new ListNode(A.charAt(A.length() - 1) - '0');
        ListNode current = dummy;
        for (int i = A.length() - 2; i > -1; i--) {
            dummy.next = new ListNode(A.charAt(i) - '0');
            dummy = dummy.next;
        }
        return current;
    }

    public static BigInteger makeListNode(ListNode l1) {
        String A = "";
        while (l1 != null) {
            A = l1.val + A;
            l1 = l1.next;
        }
        return new BigInteger(A);
    }

}
