package com.xindi.remove.nth.node.from.end_19;

import com.xindi.utils.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n){
        int len =0 ;
        ListNode cur = head;
        while(cur!=null){
            len ++;
            cur = cur.next;
        }
        //要用dummy node,避免只有一个节点，删除后为空
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = dummy;
        for(int i=0;i<len-n;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public ListNode removeNthNodeFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        //注意是<=n
        for(int i =0;i<=n;i++){
            end = end.next;
        }

        while(end!=null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}
