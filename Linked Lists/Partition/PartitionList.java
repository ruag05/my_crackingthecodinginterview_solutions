package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class PartitionList {

    //PROBLEM:
    //  Write code to partition a linked list around a value x, such that all nodes less than x come before all
    //  nodes greater than or equal to x. If x is contained within the list, the values of x only need to be
    //  after the elements less than x (see below). The partition element x can appear anywhere in the
    //  "right partition"; it does not need to appear between the left and right partitions.

    // time complexity: O(n)
    // space complexity: O(1)
    public static ListNode partition2(ListNode head, int x){
        if(head == null) return null;

        ListNode leftHead = new ListNode();
        ListNode leftCurr = leftHead;
        ListNode rightHead = new ListNode();
        ListNode rightCurr = rightHead;

        ListNode currNode = head;
        while(currNode != null){
            if(currNode.val < x){
                leftCurr.next = currNode;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = currNode;
                rightCurr = rightCurr.next;
            }
            currNode = currNode.next;
        }

        leftCurr.next = rightHead.next;
        rightCurr.next = null;

        return leftHead.next;
    }
}