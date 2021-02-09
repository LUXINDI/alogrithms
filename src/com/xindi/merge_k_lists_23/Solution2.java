package com.xindi.merge_k_lists_23;

import com.xindi.utils.ListNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists){
        return merge(lists,0, lists.length);
    }
    public ListNode merge(ListNode[] lists, int left, int right){
        if(left==right) return lists[left];
        if(left>right) return null;
        int mid = (left+right)/2;
        return mergeTwoLists(merge(lists,left,mid),merge(lists,mid+1,right));
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
