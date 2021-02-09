package com.xindi.detect_cycle_142;

import com.xindi.utils.ListNode;

public class Solution {
    //链表起点->环入口 a  环入口-》相遇点 b 相遇点-》环入口 c
    // a + n(b+c) + b = a+m(b+c)+b
    // a=(n-2m)(b+c)-b = k(b+c)+c
    // 第二次相遇点一定在环入口
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast==null||fast.next==null) return null;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
