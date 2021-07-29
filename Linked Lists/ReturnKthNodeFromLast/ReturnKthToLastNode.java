package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class ReturnKthToLastNode {

    //PROBLEM: Return Kth to Last
    //  Implement an algorithm to find the kth to last element of a singly linked list.

    // time complexity: O(n)
    // space complexity: O1)
    //uses two pointers, exactly k positions apart. Now, once the right pointer reaches null, the left pointer will be
    //at correct location
    public ListNode returnKthToLastNode(ListNode head, int k){
        ListNode nodeLeft = head;
        ListNode nodeRight = head;

        //separate the two pointers by k nodes
        for(int i = 0; i < k; i++){
            if(nodeRight == null) return null;
            nodeRight = nodeRight.next;
        }

        while(nodeRight != null){
            nodeLeft = nodeLeft.next;
            nodeRight = nodeRight.next;
        }
        return nodeLeft;
    }

    // time complexity: O(n)
    // space complexity: O1)
    //uses recursive algorithm to move from head to end and then come back till the needed index
    public int printKthToLastNode(ListNode head, int k){
        if(head == null) return 0;

        ListNode currNode = head;
        int index = printKthToLastNode(currNode.next, k) + 1; //as k values starts from 1 and not 0
        if(index == k)
            System.out.println("Value at " + k + "th node is: " + currNode.val);
        return index;
    }
}
