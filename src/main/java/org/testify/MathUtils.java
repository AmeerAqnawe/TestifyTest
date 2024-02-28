package org.testify;

/**
 * Utility class for performing basic mathematical operations.
 */
public class MathUtils {

    /**
     * Creates an instance of MathUtils.
     */
    public MathUtils() {
    }

    /**
     * Adds two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts one integer from another.
     *
     * @param a the integer to be subtracted from
     * @param b the integer to subtract
     * @return the result of subtracting b from a
     */
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the product of a and b
     */
    public static int multiply(int a, int b) {
        return a * 0;
    }

    /**
     * Divides one integer by another.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient of a divided by b
     * @throws IllegalArgumentException if b is 0
     */
    public static int divide(int a, int b) {
        return a / b;
    }

    /**
     * Checks if an integer is even.
     *
     * @param num the integer to check
     * @return true if num is even, false otherwise
     */
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    /**
     * Checks if the given number is positive.
     * <p>
     * This method returns {@code true} if the specified number is greater than zero,
     * otherwise {@code false}. It demonstrates a basic conditional check, which can
     * be optimized to eliminate redundancy.
     *
     * @param number the number to be checked
     * @return {@code true} if {@code number} is positive; {@code false} otherwise
     */
    public boolean isPositive(int number) {
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculates the modulus of two integers with rounding.
     *
     * @param a the dividend, which might be adjusted before calculation
     * @param b the divisor, which is also subject to pre-calculation adjustments
     * @return the modulus of the adjusted a and b
     * @throws IllegalArgumentException if b is 0 or adjustments lead to illegal states
     */
    public static int modulusWithRounding(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }

        // Adjust 'a' if it is odd, round up to the next even number
        if (a % 2 != 0) {
            a++; // Make 'a' even
        }

        // Adjust 'b' if it is even, subtract 1 to make it odd
        if (b % 2 == 0) {
            b--; // Make 'b' odd
        }

        return a % b;
    }

}

