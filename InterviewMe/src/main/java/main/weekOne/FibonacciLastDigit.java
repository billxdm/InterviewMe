package main.weekOne;

import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;;
        int current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (current + tmp_previous) % 10;
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

