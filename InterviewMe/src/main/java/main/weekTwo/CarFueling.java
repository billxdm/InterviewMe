package main.weekTwo;

import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int res = 0;
        int distanceTraveled = 0;
        int currStop = 1;
        if (tank < stops[0]) {
            res = -1;
            return res;
        }

        while (currStop < stops.length) {
            if(stops[currStop] - stops[currStop - 1] > tank ) {
                res = -1;
                return res;
            } else if(distanceTraveled + tank < stops[currStop]) {
                distanceTraveled = stops[currStop - 1];
                res++;
            } else if(distanceTraveled + tank == stops[currStop]) {
                distanceTraveled = stops[currStop];
                res++;
            }
            currStop++;
        }

        if (stops[stops.length - 1] + tank < dist) {
            res = -1;
        } else if (distanceTraveled < dist - tank) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
