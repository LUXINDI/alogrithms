package com.xindi.delete.duplicates2_82;

import com.xindi.utils.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            //发现重复节点
            if(cur.val == cur.next.val){
                int val = cur.val;
                //删除所有值为该值的节点
                while(cur!=null && cur.val == val){
                    prev.next = cur.next;
                    cur = cur.next;
                }
            }else{
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
