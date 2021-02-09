package com.xindi.copy_randomlist_138;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node{
    int val;
    Node next;
    Node random;
    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodemap = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            Node copy = new Node(cur.val);
            nodemap.put(cur, copy);
            cur = cur.next;
        }
        for(Node node : nodemap.keySet()){
            Node next = node.next;
            Node random = node.random;
            nodemap.get(node).next = nodemap.get(next);
            nodemap.get(node).random = nodemap.get(random);
        }
        return nodemap.get(head);
    }

    public Node copyRandomList2(Node head){
        if (head == null) return null;
        Node cur = head;
        while(cur!=null){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        //注意cur.random == null
        while(cur!=null){
            cur.next.random = cur.random==null? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node newHead = head.next;
        Node newCur = newHead;
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        //注意newCur.next == null
        while(newCur!=null){
            cur.next = cur.next.next;
            newCur.next = newCur.next==null?null:newCur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
