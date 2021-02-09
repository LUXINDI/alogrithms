package com.xindi.reorder_list_143;

import com.xindi.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
 */
public class Solution2 {
    //寻找链表中点 + 链表反转 + 链表合并
    public void reorderList(ListNode head){
        if (head==null) return;
        ListNode mid = findMiddle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null; //注意要断开
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    public ListNode findMiddle(ListNode head){
        //如果是偶数个：后半边前一个节点
        //奇数个：中间的节点
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2){
        while(l1!=null && l2!=null){
            ListNode l1_temp = l1.next;
            ListNode l2_temp = l2.next;
            l1.next = l2;
            l2.next = l1_temp;
            l2 = l2_temp;
            l1 = l1_temp;
        }
    }
}
