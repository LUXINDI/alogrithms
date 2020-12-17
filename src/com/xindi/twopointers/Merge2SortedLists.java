package com.xindi.twopointers;

import com.xindi.utils.ListNode;

public class Merge2SortedLists {
    public ListNode merge2SortedLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(node1!=null && node2!=null){
            if (node1.val <= node2.val){
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        head.next = node1!=null ? node1 : node2;
        return dummy.next;
    }
}
