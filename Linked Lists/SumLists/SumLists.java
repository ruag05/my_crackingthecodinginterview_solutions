package com.company;

public class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class SumLists {

    //PROBLEM: Sum Lists
    //  You have two numbers represented by a linked list, where each node contains a single digit.
    //  The digits are stored in reverse order, such that the 1 's digit is at the head of the list.
    //  Write a function that adds the two numbers and returns the sum as a linked list

    // time complexity: O(n + m)
    // space complexity: O(n + m)
    //uses two pointers to iterate through both the lls.
    //Also, uses two additional pointers, one to keep track of final head & another to move this final head ahead
    //(works properly if the original numbers are reversed)
    public ListNode sumLists(ListNode l1, ListNode l2){
        ListNode headA = l1;
        ListNode headB = l2;

        ListNode head = new ListNode();
        ListNode currNode = head;

        ListNode newNode;
        int carry = 0;

        while(headA != null && headB != null){
            int sum = headA.val + headB.val + carry;
            if(sum > 9){
                sum %= 10;
                newNode = new ListNode(sum);
                carry = 1;
            } else{
                newNode = new ListNode(sum);
                carry = 0;
            }
            currNode.next = newNode;
            currNode = currNode.next;
            headA = headA.next;
            headB = headB.next;
        }

        while(headA != null){
            int sum = headA.val + carry;
            if(sum > 9){
                sum %= 10;
                newNode = new ListNode(sum);
                carry = 1;
            } else{
                newNode = new ListNode(sum);
                carry = 0;
            }
            currNode.next = newNode;
            currNode = currNode.next;
            headA = headA.next;
        }
        while(headB != null){
            int sum = headB.val + carry;
            if(sum > 9){
                sum %= 10;
                newNode = new ListNode(sum);
                carry = 1;
            } else{
                newNode = new ListNode(sum);
                carry = 0;
            }
            currNode.next = newNode;
            currNode = currNode.next;
            headB = headB.next;
        }
        if(carry == 1) {
            newNode = new ListNode(1);
            currNode.next = newNode;
        }
        return head.next;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //uses recursion to sum up the node values (works properly if the original numbers are reversed)
    public ListNode sumLists2(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;

        ListNode newNode = new ListNode();
        int sum = 0;
        if(l1 != null) sum += l1.val;
        if(l2 != null) sum += l2.val;
        newNode.val = sum % 10;

        newNode.next = sumLists2(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum > 9 ? 1 : 0);

        return newNode;
    }
    public ListNode sumLists2(ListNode l1, ListNode l2, int carry){
        if(carry == 0 && l1 == null && l2 == null) return null;

        ListNode newNode = new ListNode();
        int sum = carry;
        if(l1 != null) sum += l1.val;
        if(l2 != null) sum += l2.val;
        newNode.val = sum % 10;

        if(l1 != null || l2 != null) {
            newNode.next = sumLists2(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    sum > 9 ? 1 : 0);
        }
        return newNode;
    }
}
