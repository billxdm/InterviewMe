package main.weekOne;

import java.util.*;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        int bigNum = a;
        int smallNum = b;
        if ( a == b ) {
            return a;
        } else if ( a < b) {
            bigNum = b;
            smallNum = a;
        }
        do {
            current_gcd = smallNum;
            int smallNumInterim = smallNum;
            smallNum = bigNum % smallNum;
            bigNum = smallNumInterim;
        } while ( smallNum != 0);

        return current_gcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}
