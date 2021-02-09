package com.xindi.sort_list_148;

import com.xindi.utils.ListNode;

public class Solution {
    public ListNode sortList(ListNode head){
        if(head == null||head.next==null) return head;
        ListNode mid = findMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        return merge(left,right);
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left!=null&&right!=null){
            if(left.val<=right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left!=null? left : right;
        return dummy.next;
    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
