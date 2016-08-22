package com.legend.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * #383 Given an arbitrary ransom note string and another string containing
 * letters from all the magazines, write a function that will return true if the
 * ransom note can be constructed from the magazines ; otherwise, it will return
 * false. Each letter in the magazine string can only be used once in your
 * ransom note.
 *
 * Note: You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

	public boolean canConstruct1(String ransomNote, String magazine) {
		boolean flag = true;
		HashMap<Character, Integer> m_t = new HashMap<Character, Integer>();

		for (int i = 0; i < magazine.length(); i++) {
			if (null != m_t.get(magazine.charAt(i))) {
				m_t.put(magazine.charAt(i), m_t.get(magazine.charAt(i)) + 1);
			} else {
				m_t.put(magazine.charAt(i), 1);
			}
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (null == m_t.get(ransomNote.charAt(i)) || 0 == m_t.get(ransomNote.charAt(i))) {
				flag = false;
				break;
			} else {
				m_t.put(ransomNote.charAt(i), m_t.get(ransomNote.charAt(i)) - 1);
			}
		}

		return flag;
	}

	/**
	 * JDK8 新特性
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct2(String ransomNote, String magazine) {
		Map<Character, Integer> magM = new HashMap<>();

		for (char c : magazine.toCharArray()) {
			int newCount = magM.getOrDefault(c, 0) + 1;
			magM.put(c, newCount);
		}

		for (char c : ransomNote.toCharArray()) {
			int newCount = magM.getOrDefault(c, 0) - 1;
			if (newCount < 0)
				return false;
			magM.put(c, newCount);
		}

		return true;
	}

	public boolean canConstruct3(String ransomNote, String magazine) {
		int[] arr = new int[26];

		for (int i = 0; i < magazine.length(); i++) {
			arr[magazine.charAt(i) - 'a']++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		RansomNote rn = new RansomNote();
		System.out.println(rn.canConstruct1("abc", "abcd"));
		System.out.println(rn.canConstruct2("asd", "abcd"));
		System.out.println(rn.canConstruct3("bb", "abcdb"));
	}
}
