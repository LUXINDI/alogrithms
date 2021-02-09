package com.xindi.merge_k_lists_23;

import com.xindi.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists){
        ListNode head = null;
        for(int i=0;i<lists.length;i++){
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }
    public ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(node1!=null&&node2!=null){
            if(node1.val<=node2.val){
                cur.next = node1;
                node1=node1.next;
            }else{
                cur.next = node2;
                node2=node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1!=null ? node1 : node2;
        return dummy.next;
    }
}
