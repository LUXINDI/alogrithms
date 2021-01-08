package com.xindi.addtwonums_2;

import com.xindi.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        int n = 1;
        int res = 0;
        while(l1!=null || l2!=null){
            int n1 = l1==null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int num = (carry + n1 + n2)%10;
            carry = (carry + n1 + n2)/10;
            res = res + num * n;
            n = n*10;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        res = res + carry * n;
        return res;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1!=null || l2!=null){
            int n1 = l1==null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int num = (carry + n1 + n2)%10;
            carry = (carry + n1 + n2)/10;
            head.next = new ListNode(num);
            head = head.next;
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }
        if (carry > 0){
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode res = sol.addTwoNumbers2(new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(res);
    }
}
