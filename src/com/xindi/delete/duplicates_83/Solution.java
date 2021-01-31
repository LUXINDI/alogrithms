package com.xindi.delete.duplicates_83;

import com.xindi.utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head){
        if (head == null) return head;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            while(cur.next!=null && cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
