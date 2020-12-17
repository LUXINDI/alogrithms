package com.xindi;

import com.xindi.utils.ListNode;

import java.util.Stack;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int len = 0;
        while (cur!=null){
            cur = cur.next;
            len ++;
        }
        int num = len - n;
        ListNode prev = dummy;
        for(int i=0;i<num;i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        for(int i=0;i<n;i++){
            stack.pop();
        }
        ListNode node = stack.peek();
        node.next = node.next.next;
        return dummy.next;
    }
}
