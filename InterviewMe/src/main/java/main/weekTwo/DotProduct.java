package main.weekTwo;

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        mergeSort(a, 0, a.length - 1);
        mergeSort(b, 0, b.length - 1);
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (long)a[i] * (long)b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }

    private static void mergeSort(int[] b, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(b, left, mid);
            mergeSort(b, mid + 1,  right);
            merge(b, left, mid, right);
        }
    }

    private static void merge(int[] b, int left, int mid, int right) {
        int leftArrayLen = mid - left + 1;
        int rightArrayLen = right - mid;
        int[] leftArray = new int[leftArrayLen];
        int[] rightArray = new int[rightArrayLen];
        System.arraycopy(b, left, leftArray, 0, leftArrayLen);
        System.arraycopy(b, mid + 1, rightArray, 0, rightArrayLen);
        int i =0;
        int j = 0;
        int beginningPoint = left;
        while(i < leftArrayLen && j < rightArrayLen) {
            if (leftArray[i] < rightArray[j]) {
                b[beginningPoint] = leftArray[i];
                i++;
                beginningPoint++;
            } else {
                b[beginningPoint] = rightArray[j];
                j++;
                beginningPoint++;
            }
        }
        while (j < rightArrayLen) {
            b[beginningPoint] = rightArray[j];
            j++;
            beginningPoint++;
        }
        while (i < leftArrayLen) {
            b[beginningPoint] = leftArray[i];
            i++;
            beginningPoint++;
        }

    }

}


