package main.weekTwo;

import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        TreeMap<Double, Integer> valueByUnit = new TreeMap<>();
        for (int i = 0; i < values.length; i++) {
            double a = (double) values[i] / weights[i];
            valueByUnit.put(a, i);
        }
        List<Double> sortedByValues = new ArrayList<>(valueByUnit.keySet());
        sortedByValues.sort(Collections.reverseOrder());

        for (Double sortedValue : sortedByValues) {
            int spiceOrder = valueByUnit.get(sortedValue);
            int weightOfMostValue = weights[spiceOrder];
            int weightToAdd = Math.min(capacity, weightOfMostValue);
            value += sortedValue * weightToAdd;
            capacity -= weightToAdd;
            if (capacity <= 0) {
                break;
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
