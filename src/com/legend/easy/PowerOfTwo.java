package com.legend.easy;

/**
 * #231 Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        System.out.println(pot.isPowerOfTwo(8));
    }
}
