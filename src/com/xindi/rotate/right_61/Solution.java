package com.xindi.rotate.right_61;

import com.xindi.utils.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k){
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        int n = 0;
        while(cur.next!=null){
            cur=cur.next;
            n++;
        }
        //首尾相连
        cur.next = dummy.next;
        //尾：n-k%n
        ListNode newTail = dummy;
        for(int i=0;i<n-k%n;i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
