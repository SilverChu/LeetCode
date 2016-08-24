package com.legend.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * #217 Given an array of integers, find if the array contains any duplicates. Your function should return true if
 * any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        final Set<Integer> distinct = new HashSet<>();

        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = {1, 2, 2, 3, 4};
        boolean flag1 = cd.containsDuplicate1(nums);
        boolean flag2 = cd.containsDuplicate2(nums);
        boolean flag3 = cd.containsDuplicate3(nums);
        System.out.println(flag3);
    }
}
