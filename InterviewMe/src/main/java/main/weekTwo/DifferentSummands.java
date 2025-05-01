package main.weekTwo;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        int sum = 0;
        int currentNum = 1;
        boolean exit = true;
        List<Integer> summands = new ArrayList<Integer>();
        while (exit) {
            if (sum + 2 * currentNum + 1 <= n) {
                summands.add(currentNum);
                sum += currentNum;
                currentNum++;
            } else {
                summands.add(n - sum);
                exit = false;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}


