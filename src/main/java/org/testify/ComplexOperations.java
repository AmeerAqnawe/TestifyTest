package org.testify;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ComplexOperations} class provides methods for performing various mathematical operations,
 * such as calculating the square and cube of a number, checking if a number is prime, calculating the factorial
 * of a number, checking if a string is a palindrome, and generating a list of prime numbers.
 */
public class ComplexOperations {

    /**
     * Constructs a new {@code ComplexOperations} object.
     */
    public ComplexOperations() {
    }

    /**
     * Calculates the square of a given number.
     *
     * @param num The number to be squared.
     * @return The square of {@code num}.
     * @throws IllegalArgumentException If {@code num} is less than 0.
     */
    public int calculateSquare(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("the number should be greater than zero");
        }
        return num * num;
    }

    /**
     * Calculates the cube of a given number.
     *
     * @param num The number to be cubed.
     * @return The cube of {@code num}.
     * @throws IllegalArgumentException If {@code num} is less than 0.
     */
    public int calculateCube(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("the number should be greater than zero");
        }
        return num * num * num;
    }

    /**
     * Checks if the given number is prime.
     *
     * @param num The number to be checked.
     * @return {@code true} if {@code num} is a prime number, {@code false} otherwise.
     */
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param num The number to calculate the factorial of.
     * @return The factorial of {@code num}.
     * @throws IllegalArgumentException If {@code num} is less than 0.
     */
    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (num == 0 || num == 1) {
            return 1;
        }
        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Checks if the given string is a palindrome.
     *
     * @param str The string to be checked.
     * @return {@code true} if {@code str} is a palindrome, {@code false} otherwise.
     * @throws IllegalArgumentException If {@code str} is null.
     */
    public boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    /**
     * Generates a list of the first {@code n} prime numbers.
     *
     * @param n The number of prime numbers to generate.
     * @return A list containing the first {@code n} prime numbers.
     */
    public List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                primes.add(num);
                count++;
            }
            num++;
        }
        return primes;
    }

    /**
     * Calculates the n-th Fibonacci number to demonstrate recursion and potential for stack overflow.
     *
     * @param n The position in the Fibonacci sequence.
     * @return The n-th Fibonacci number.
     * @throws IllegalArgumentException If {@code n} is negative.
     */
    public int calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    /**
     * Evaluates if a string is an anagram of another string.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return {@code true} if {@code s1} and {@code s2} are anagrams, {@code false} otherwise.
     */
    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("String inputs cannot be null.");
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letterCounts = new int[256]; // Assuming ASCII
        for (char c : s1.toCharArray()) {
            letterCounts[c]++;
        }
        for (char c : s2.toCharArray()) {
            if (--letterCounts[c] < 0) {
                return false;
            }
        }
        return true;
    }

}
