package org.testify;


import java.util.ArrayList;
import java.util.List;

public class ComplexOperations {
    public static int calculateSquare(int num) {
        return num * num;
    }

    public static int calculateCube(int num) {
        return num * num * num;
    }

    public static List<Integer> generatePrimes(int n) {
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

    public static boolean isPrime(int num) {
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

    public static int factorial(int num) {
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

    public static boolean isPalindrome(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
