package main.weekOne;

import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    private static long  getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;
        long lastNumAfterMod = 0;
        long currentNumberAfterMod = 1;
        long pisanoNum = getPisanoPeriod(m);
        n = n % pisanoNum;
        for (long i = 2; i <= n ; i++) {
            long temp = lastNumAfterMod;
            lastNumAfterMod = currentNumberAfterMod;
            currentNumberAfterMod = (temp + lastNumAfterMod) % m;
        }

        return n == 0 ? lastNumAfterMod : currentNumberAfterMod;

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
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

