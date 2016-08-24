package com.legend.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * #169 Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    // Most Popular Answer
    public int majorityElement1(int[] nums) {
        int ret = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                ret = num;
            }
            if (num != ret) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

    // Solving Question By HashMap
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int ret = 0;

        for (int num : nums) {
            if (!tempMap.containsKey(num)) {
                tempMap.put(num, 1);
            } else {
                tempMap.put(num, tempMap.get(num) + 1);
            }
            if (tempMap.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // Sorting
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Bit Manipulation ---- Hard To Understand
    public int majorityElement(int[] nums) {
        int[] bit = new int[32];

        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31 - i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {3, 1, 3, 2, 3, 3, 3, 4, 3, 5, 3};
        int result1 = me.majorityElement1(nums);
        int result2 = me.majorityElement2(nums);
        System.out.println(result1);
        System.out.println(result2);
    }
}
