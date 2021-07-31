package com.company;

import java.util.HashSet;
import java.util.Set;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {

    //PROBLEM:
    //  Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop

    public static void main(String[] args) {

    }

    // time complexity: O(n)
    // space complexity: O(n)
    //uses HashSet to throw the node as soon as the duplicate node is encountered
    public ListNode detectCycle(ListNode head){
        if(head == null) return null;

        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode currNode = head;
        while(currNode != null) {
            if(visitedNodes.contains(currNode)){
                return currNode;
            }
            visitedNodes.add(currNode);
            currNode = currNode.next;
        }
        return null;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    //uses fast and slow pointer to first detect the intersection then to again iterate the linked list, with one
    //pointer at start and other from intersection
    public static ListNode detectCycle2(ListNode head){
        if(head == null) return null;

        ListNode intersectNode = getIntersection(head);
        if(intersectNode == null) return null;

        ListNode currNode = head;
        while(currNode != intersectNode) {
            currNode = currNode.next;
            intersectNode = intersectNode.next;
        }
        return intersectNode;
    }
    public static ListNode getIntersection(ListNode head){
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode) return slowNode;
        }
        return null;
    }
}
