package com.company;

public class StringRotation {

    //PROBLEM : Rotate String
    //  -Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
    //
    //  A shift on s consists of moving the leftmost character of s to the rightmost position.
    //
    //  For example, if s = "abcde", then it will be "bcdea" after one shift.
    //
    //  -Constraints:
    //  1 <= s.length, goal.length <= 100
    //  s and goal consist of lowercase English letters

    public static void main(String[] args) {
        String s = "bbbacddceeb";
        String goal = "ceebbbbacdd";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal){
        if(s.length() != goal.length()) return false;

        return isSubstring(s.concat(s), goal); //where isSubstring is an existing method which checks whether
                                               //a word is a substring of another string
    }
}
