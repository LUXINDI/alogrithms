package com.xindi.offer.treeToDoublyList_36;
import com.xindi.utils.Node;
//自己写出来了
class ResultType{
    Node head;
    Node tail;
    ResultType(Node head, Node tail){
        this.head = head;
        this.tail = tail;
    }
}

public class Solution {
    public Node treeToDoublyList(Node node){
        if(node ==null) return null;
        ResultType res = helper(node);
        res.head.left=res.tail;
        res.tail.right = res.head;
        return res.head;
    }

    public ResultType helper(Node node){
        if(node==null) return null;
        if(node.left==null && node.right==null){
            return new ResultType(node,node);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        Node head = node;
        Node tail = node;
        if(left!=null){
            left.tail.right = node;
            node.left = left.tail;
            head = left.head;
        }
        if(right!=null){
            node.right = right.head;
            right.head.left = node;
            tail = right.tail;
        }
        return new ResultType(head, tail);
    }
}
