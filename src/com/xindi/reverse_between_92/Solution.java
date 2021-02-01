package com.xindi.reverse_between_92;

import com.xindi.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode/
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m , int n){
        if(head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        for(int i=0;i<m-1;i++){
            prev = cur;
            cur = cur.next;
        }
        ListNode con = prev;
        ListNode tail = cur;
        // 1->2(con)->3(tail)->4 -> 5 -> 6 (3,5)
        // 1->2(con)<-3(tail)<-4 <- 5(prev) -> 6(cur)
        for(int i=0;i<=n-m;i++){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        if(con!=null){
            con.next = prev;
        }else{
            head = prev;
        }
        tail.next = cur;
        return head;
    }

}
