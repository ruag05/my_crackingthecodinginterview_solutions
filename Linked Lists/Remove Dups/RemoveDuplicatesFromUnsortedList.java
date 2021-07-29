package com.company;

import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;

public class ListNode {
    int val;
    com.company.ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, com.company.ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicatesFromUnsortedList {

    //PROBLEM : Remove Duplicates from Unsorted List
    // Write code to remove duplicates from an unsorted linked list.

    // time complexity: O(n)
    // space complexity: O(n)
    //uses Hashtable to store the node values as keys and their frequency as values
    public com.company.ListNode removeDups(com.company.ListNode head){
        if(head == null) return null;
        if(head.next != null) return head;

        Hashtable<Integer, Integer> table = new Hashtable<>();
        com.company.ListNode currNode = head;
        while(currNode != null){
            table.put(currNode.val, table.getOrDefault(currNode.val, 0) + 1);
            currNode = currNode.next;
        }

        currNode = head;
        for(Integer val : table.values()) {
            currNode.val = val;
            currNode = currNode.next;
        }

        return head;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //uses HashSet to store the node values uniquely and use the 'contains' method to check if the number is already
    //present
    public com.company.ListNode removeDups2(com.company.ListNode head){
        if(head == null) return null;
        if(head.next != null) return head;

        com.company.ListNode currNode = head;

        Set<Integer> set = new HashSet<>();
        set.add(currNode.val);

        while(currNode != null) {
            while(currNode.next != null && set.contains(currNode.next.val)){
                currNode.next = currNode.next.next;
            }
            if(currNode.next != null)
                set.add(currNode.next.val);
            else
                return head;

            currNode = currNode.next;
        }
        return head;
    }
}
