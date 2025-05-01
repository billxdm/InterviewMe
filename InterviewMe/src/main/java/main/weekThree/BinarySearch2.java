package main.weekThree;
import java.io.*;
import java.util.*;

public class BinarySearch2 {

    static int binarySearch(int[] a, int x) {
        int res = -1;
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int medium = left + (right - left) / 2;
            if (a[medium] == x) {
                res = medium;
                break;
            } else if (a[medium] > x) {
                right = medium -1;
            } else {
                left = medium + 1;
            }
        }
//        boolean isFrist = true;
//        while (isFrist) {
//            if (res == -1 || res == 0) {
//                isFrist = false;
//            } else if ( a[res - 1] != a[res]) {
//                isFrist = false;
//            } else {
//                res--;
//            }
//        }

        while (res > 0 && a[ res - 1] == a[res]) {
            res--;
        }


        return res;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

