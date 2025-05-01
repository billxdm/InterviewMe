package main.weekTwo;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int length = segments.length;
        int start = 0;
        int end = 0;
        sortSegments(segments);
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (start == 0 && end == 0) {
                start = segments[i].start;
                end = segments[i].end;
            } else if (end < segments[i].start) {
                points.add(end);
                start = segments[i].start;
                end = segments[i].end;
                if (i == length - 1) {
                    points.add(end);
                }
            }else if (segments[i].start > start) {
                start = segments[i].start;
                if(i == length - 1) {
                    points.add(end);
                }
            } else if ( segments[i].end < end) {
                end = segments[i].end;
                if(i == length - 1) {
                    points.add(end);
                }
            }

        }

        return points.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void sortSegments(Segment[] segments) {
        int n = segments.length;
        for ( int i = n / 2 - 1; i >= 0; i--) {
            heapify(segments, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(segments, i, 0);
            heapify(segments, i, 0);
        }
    }

    private static void heapify(Segment[] segments, int length, int pos) {
        int largest = pos;
        int leftChild = pos * 2 + 1;
        int rightChild = pos * 2 + 2;

        if (leftChild < length && segments[leftChild].start > segments[largest].start) {
            largest = leftChild;
        }

        if (rightChild < length && segments[rightChild].start > segments[largest].start) {
            largest = rightChild;
        }

        if (largest != pos) {
            swap(segments, largest, pos);
            heapify(segments, length, largest);
        }

    }

    private static void swap(Segment[] segments, int posOne, int posTwo) {
        Segment temp = segments[posOne];
        segments[posOne] = segments[posTwo];
        segments[posTwo] = temp;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

