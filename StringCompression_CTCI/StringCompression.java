package com.company;

public class StringCompression {

    //PROBLEM: String Compression
    //  -Implement a method to perform basic string compression using the counts
    //  of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    //  "compressed" string would not become smaller than the original string, your method should return
    //  the original string. You can assume the string has only uppercase and lowercase letters (a - z)

    public static void main(String[] args) {
        String s = "abbb";
        System.out.println(stringCompression(s));
    }

    //took 142 ms (98 percentile - lintcode) and 13.65 MB
    public static String stringCompression(String s){
        StringBuilder sb = new StringBuilder();
        int varCounter = 1;

        if(s.length() == 0) return "";
        else sb.append(s.charAt(0));

        for(int j = 0; j < s.length() - 1; j++){
            if(s.charAt(j) == s.charAt(j + 1)) varCounter++;
            else{
                sb.append(varCounter);
                varCounter = 1;
                sb.append(s.charAt(j + 1));
            }
        }
        sb.append(varCounter);
        return sb.toString().length() >= s.length() ? s : sb.toString();
    }
}
