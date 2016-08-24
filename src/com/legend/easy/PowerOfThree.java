package com.legend.easy;

/**
 * #326 Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree {

    // Recursive
    public boolean isPowerOfThree1(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree1(n / 3)));
    }

    //Iterative
    public boolean isPowerOfThree2(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }

    public boolean isPowerOfThree3(int n) {
        return n > 0 && (1162261467 % n == 0); //3^19 = maxPowerOfThree
    }

    public boolean isPowerOfThree4(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree5(int n) {
        return n == 0 ? false : n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}
