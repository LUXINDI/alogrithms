package com.xindi.reorder_list_143;

import com.xindi.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void reorderList(ListNode head){
        if(head == null) return;
        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            nodeList.add(cur);
            cur = cur.next;
        }
        int i = 0;
        int j = nodeList.size()-1;
        while(i<j){
            nodeList.get(i).next = nodeList.get(j);
            if(i+1==j) {//偶数个节点
                nodeList.get(j).next = null;
                return;
            }else{
                nodeList.get(j).next = nodeList.get(i + 1);
            }
            i++;
            j--;
        }
        //奇数个节点
        nodeList.get(i).next = null;
    }
}
