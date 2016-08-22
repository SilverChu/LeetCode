package com.legend.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * #349 Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 */
public class IntersectionOfTwoArray {

	/**
	 * set类的特性解决交集问题
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int[] intersection1(int[] num1, int[] num2) {

		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> intersect = new HashSet<>();

		for (int i = 0; i < num1.length; i++) {
			set.add(num1[i]);
		}

		for (int i = 0; i < num2.length; i++) {
			if (set.contains(num2[i])) {
				intersect.add(num2[i]);
			}
		}

		int[] result = new int[intersect.size()];
		int i = 0;
		for (Integer num : intersect) {
			result[i++] = num;
		}
		return result;
	}

	/**
	 * 对两个集合进行排序,并使用指针计算出结果
	 *
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int[] intersection2(int[] num1, int[] num2) {
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(num1);
		Arrays.sort(num2);
		int i = 0;
		int j = 0;

		while (i < num1.length && j < num2.length) {
			if (num1[i] < num2[j]) {
				i++;
			} else if (num1[i] > num2[j]) {
				j++;
			} else {
				set.add(num1[i]);
				i++;
				j++;
			}
		}

		int[] result = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			result[k++] = num;
		}
		return result;
	}

	public int[] intersection3(int[] num1, int[] num2) {
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(num2);

		for (Integer num : num1) {
			if (binarySearch(num2, num)) {
				set.add(num);
			}
		}

		int[] result = new int[set.size()];
		int i = 0;
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}

	/**
	 * 二分查找
	 *
	 * @param nums
	 *            被排序的int数组
	 * @param target
	 *            目标数字
	 * @return
	 */
	private boolean binarySearch(int[] nums, Integer target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		IntersectionOfTwoArray iota = new IntersectionOfTwoArray();
		int[] num1 = { 1, 2, 2, 3 };
		int[] num2 = { 2, 2, 1 };
		int[] result1 = iota.intersection1(num1, num2);
		int[] result2 = iota.intersection2(num1, num2);
		int[] result3 = iota.intersection3(num1, num2);
		System.out.println(Arrays.toString(result1)); // ??????????
		System.out.println(Arrays.toString(result2));
		System.out.println(Arrays.toString(result3));
	}
}
