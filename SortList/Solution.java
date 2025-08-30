package win.SortList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list1 = sort(head);
        if (list1.isEmpty())
            return null;
        ListNode dummy = new ListNode(list1.get(0));
        ListNode current = dummy;
        for (int i = 1; i < list1.size(); i++) {
            current.next = new ListNode(list1.get(i));
            current = current.next;
        }
        return dummy;
    }

    public ArrayList sort(ListNode head) {
        ArrayList list1 = new ArrayList();
        while (head != null) {
            list1.add(head.val);
            head = head.next;
        }
        Collections.sort(list1);
        return list1;
    }

}