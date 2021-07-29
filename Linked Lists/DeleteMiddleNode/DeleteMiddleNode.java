package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class DeleteMiddleNode {

    //PROBLEM: Delete Middle Node
    //  Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
    //  not necessarily the exact middle) of a singly linked list, given only access to that node.

    // time complexity: O(1)
    // space complexity: O(1)
    //replaces the value in current node with its next node value and bypasses that node to connect to next one
    public boolean deleteNode(ListNode n){
        if(n == null) return false;
        ListNode nextNode = n.next;
        n.val = nextNode.val;
        n.next = nextNode.next;
        return true;
    }
}
