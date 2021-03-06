package com.legend.easy;

/**
 * #258 Given a non-negative integer num, repeatedly add all its digits until
 * the result has only one digit.
 * <p>
 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * <p>
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * Hint: A naive implementation of the above process is trivial. Could you come
 * up with other methods? What are all the possible results? How do they occur,
 * periodically or randomly? You may find this Wikipedia article useful.
 */
public class AddDigits {

    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        int result = ad.addDigits(99);
        System.out.println(result);
    }
}
