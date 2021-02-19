package com.xindi.intersection_of_two_linked_lists_160;

import com.xindi.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 * 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。
 **/
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode pA = headA;
        ListNode pB = headB;
        boolean firstA = true;
        boolean firstB = true;
        while(pA!=null&&pB!=null){
            if(pA==pB){
                return pA;
            }
            if(pA.next==null && firstA){
                pA = headB;
                firstA = false;
            }else{
                pA = pA.next;
            }
            if(pB.next==null && firstB){
                pB = headA;
                firstB = false;
            }else{
                pB = pB.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if(headA==null||headB==null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB){
            pA = pA==null ? headB : pA.next;
            pB = pB==null ? headA : pB.next;
        }
        return pA;
    }
}
