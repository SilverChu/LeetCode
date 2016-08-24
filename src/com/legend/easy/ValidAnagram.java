package com.legend.easy;

/**
 * #242 Given two strings s and t, write a function to determine if t is an
 * anagram of s.
 * <p>
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * <p>
 * Note: You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        boolean flag = va.isAnagram("anagram", "nagaram");
        System.out.println(flag);
    }
}
