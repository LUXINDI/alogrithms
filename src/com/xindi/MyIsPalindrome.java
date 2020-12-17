package com.xindi;

import com.xindi.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/** reference: https://leetcode-cn.com/problems/palindrome-linked-list/submissions/ * */

public class MyIsPalindrome {
  // 时间复杂度O(n)
  // 空间复杂度O(n)
  public boolean isPalindrome1(ListNode head){
    List<Integer> list = new ArrayList<>();
    while(head!=null){
      list.add(head.val);
      head = head.next;
    }
    int left = 0;
    int right = list.size()-1;
    while(left < right){
      if(!list.get(left).equals(list.get(right))){
        return false;
      } else{
        left ++;
        right --;
      }
    }
    return true;
  }

  public boolean isPalindrome2(ListNode head){
    if(head == null){
      return true;
    }
    ListNode endOfFirstHalf = findMiddle(head);
    ListNode startOfSecondHalf = reverseListNode(endOfFirstHalf.next);
    ListNode cur = startOfSecondHalf;
    boolean result = true;
    while(cur!=null){
      if (cur.val != head.val) result = false;
      cur = cur.next;
      head = head.next;
    }
    endOfFirstHalf.next = reverseListNode(startOfSecondHalf);
    return result;

  }

  public ListNode reverseListNode(ListNode head){
    ListNode prev = null;
    while(head!=null){
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }

  public ListNode findMiddle(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next!=null && fast.next.next!=null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
