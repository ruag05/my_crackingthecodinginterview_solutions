package com.company;

public class EditDistance {

    //PROBLEM
    //  -There are three types of edits that can be performed on strings: insert a character,
    //  remove a character, or replace a character. Given two strings, write a function to check if they are
    //  one edit (or zero edits) away.

    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "ab";
        System.out.println(oneAway2(word1, word2));
    }

    //if the problem asks whether the strings are 0/1 edits away
    public static boolean oneAway(String word1, String word2){

        //if second word's length is greater/smaller than first word's length by more than 1,
        //then it is not oneAway
        if(Math.abs(word1.length() - word2.length()) > 1 ) return false;
        int misMatchCounter = 0;
        int i = 0, j = 0;

        //traverse both words comparing their characters
        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) != word2.charAt(j)){
                misMatchCounter++;
                if(misMatchCounter > 1) return false;
                if(word1.length() > word2.length()) i++;
                else if(word1.length() < word2.length()) j++;
                else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    //if the problem asks whether the strings are exactlt 1 edit away
    //took 162 ms (93 percentile - lintcode) and 14.9 MB
    public static boolean oneAway2(String word1, String word2){

        //if second word's length is greater/smaller than first word's length by more than 1,
        //then it is not oneAway
        if(Math.abs(word1.length() - word2.length()) > 1 ) return false;
        int misMatchCounter = 0;
        int i = 0, j = 0;

        //traverse both words comparing their characters
        while(i < word1.length() && j < word2.length()){
            if(word1.charAt(i) != word2.charAt(j)){
                misMatchCounter++;
                if(misMatchCounter > 1) return false;
                if(word1.length() > word2.length()) i++;
                else if(word1.length() < word2.length()) j++;
                else {
                    i++;
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        while(i < word1.length()) {
            misMatchCounter++;
            i++;
        }
        while(j < word2.length()) {
            misMatchCounter++;
            j++;
        }

        return misMatchCounter == 1;
    }
}
