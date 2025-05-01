package main.weekOne;

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;
        long[] arrayN = new long[n + 1];
        arrayN[0] = 0;
        arrayN[1] = 1;
        for (int i = 2; i <= n; i++) {
            arrayN[i] = arrayN[i - 1] + arrayN[i - 2];
        }
        return arrayN[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calc_fib(n));
    }
}
