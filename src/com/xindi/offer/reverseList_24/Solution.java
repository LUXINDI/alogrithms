package com.xindi.offer.reverseList_24;

import com.xindi.utils.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
