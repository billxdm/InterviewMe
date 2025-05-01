package main.weekOne;

import java.util.*;
public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;
        long sum = 1;
        long pisano = getPisanoPeriod(10);
        for (int i = 2; i <= pisano; i++) {
            long temp = previous;
            previous = current;
            current = (temp + current) % 10;
            sum = (sum + current * current) % 10;
        }
        sum = (sum * ((long) n / pisano) ) % 10 + 1;
        n = n % pisano;
        previous = 0;
        current  = 1;
        for (long i = 2; i <= n; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            sum = (sum + current * current) % 10;
        }

        return n == 0 ? 0 : sum;
    }
    private static long getPisanoPeriod(long m) {
        long prev = 0;
        long curr = 1;
        for (int i = 0; i < m * m; i++) {
            long temp = prev;
            prev = curr;
            curr = (temp + curr) % m;
            if (prev == 0 && curr == 1) {
                return i + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}
