package main.weekTwo;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {

        mergeSort(a, 0, a.length - 1);
        String result = "";
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }


    private static void mergeSort(String[] a, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(String[] a, int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLengh = right - mid;
        String[] leftArray = new String[leftLength];
        String[] rightArray = new String[rightLengh];
        System.arraycopy(a,left, leftArray,0, leftLength);
        System.arraycopy(a, mid + 1, rightArray, 0, rightLengh);
        int i = 0;
        int j = 0;
        int start = left;
        while (i < leftLength && j < rightLengh) {
            if (compare(leftArray[i],rightArray[j])) {
                a[start] = leftArray[i];
                i++;
                start++;
            } else {
                a[start] = rightArray[j];
                j++;
                start++;
            }
        }
        while (i < leftLength) {
            a[start] = leftArray[i];
            i++;
            start++;
        }

        while (j < rightLengh) {
            a[start] = rightArray[j];
            j++;
            start++;
        }
    }

    private static boolean compare(String a, String b) {
        return (a + b).compareTo(b + a) > 0;
    }

//    private static boolean compare(String a, String b) {
//        boolean res = true;
//        int aLen = a.length();
//        int bLen = b.length();
//        int aPoint = 0;
//        int bPoint = 0;
//        while (aPoint < aLen || bPoint < bLen) {
//            if (a.charAt(aPoint) > b.charAt(bPoint)) {
//                break;
//            } else if (a.charAt(aPoint) < b.charAt(bPoint)) {
//                res = false;
//                break;
//            } else {
//                if (aPoint == aLen - 1 && bPoint == bLen - 1) {
//                    break;
//                }
//                if (aPoint < aLen - 1) {
//                    aPoint++;
//                }
//                if (bPoint < bLen - 1) {
//                    bPoint++;
//                }
//            }
//
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

