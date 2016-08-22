package com.legend.leetcode;

/**
 * #344 Write a function that takes a string as input and returns the string
 * reversed. Example:Given s = "hello", return "olleh".
 */
public class ReverseString {

	/**
	 * StringBuffer API��ת�ַ���
	 * 
	 * @param s
	 *            ������ַ���
	 * @return ��ת����ַ���
	 */
	public String reverseString1(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	/**
	 * �����ַ�char��ת����
	 * 
	 * @param s
	 *            ������ַ���
	 * @return ��ת����ַ���
	 */
	public String reverseString2(String s) {
		char[] word = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			char temp = word[start];
			word[start] = word[end];
			word[end] = temp;
			start++;
			end--;
		}
		return new String(word);
	}

	/**
	 * �����ֽ�byte��ת����(�������)
	 * 
	 * @param s
	 *            ������ַ���
	 * @return ��ת����ַ���
	 */
	public String reverseString3(String s) {
		byte[] word = s.getBytes();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			word[start] = (byte) (word[start] ^ word[end]);
			word[end] = (byte) (word[start] ^ word[end]);
			word[start] = (byte) (word[start] ^ word[end]);
			start++;
			end--;
		}
		return new String(word);
	}

	/**
	 * �ݹ鷽ʽƴ���ַ����ﵽ��ת�ַ���Ч��
	 * 
	 * @param s
	 *            ������ַ���
	 * @return ��ת����ַ���
	 */
	public String reverseString4(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String leftString = s.substring(0, length / 2);
		String rightString = s.substring(length / 2, length);
		return reverseString4(rightString) + reverseString4(leftString);
	}

	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		String str1 = rs.reverseString1("String");
		String str2 = rs.reverseString2("String");
		String str3 = rs.reverseString3("String");
		String str4 = rs.reverseString4("String");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
	}
}
