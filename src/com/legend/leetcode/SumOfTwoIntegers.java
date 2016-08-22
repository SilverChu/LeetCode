package com.legend.leetcode;

/**
 * #371 Calculate the sum of two integers a and b, but you are not allowed to
 * use the operator + and -.Example:Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {

	public int getSum1(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	public int getSum2(int a, int b) {
		return (b == 0) ? a : getSum2(a ^ b, (a & b) << 1);
	}

	public int getSubtract1(int a, int b) {
		while (b != 0) {
			int borrow = ~a & b;
			a = a ^ b;
			b = borrow << 1;
		}
		return a;
	}

	public int getSubtract2(int a, int b) {
		return (b == 0) ? a : getSubtract2(a ^ b, (~a & b) << 1);
	}

	public static void main(String[] args) {
		SumOfTwoIntegers soti = new SumOfTwoIntegers();
		int sum1 = soti.getSum1(1, 3);
		int subtract1 = soti.getSubtract1(1, 3);
		System.out.println(sum1);
		System.out.println(subtract1);
	}
}
