package com.legend.leetcode;

/**
 * #171 Given a column title as appear in an Excel sheet, return its
 * corresponding column number.
 * 
 * For example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 */
public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
		int result = escn.titleToNumber("BK");
		System.out.println(result);
	}
}
