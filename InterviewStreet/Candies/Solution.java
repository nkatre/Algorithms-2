/*
 * @author Sanjay Paul
 * @date 01.02.2012
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("tests.txt"));
        //BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(buff.readLine().trim());
        int[] R = new int[cnt+1];
        R[0] = -1;
        for (int i = 1; i < cnt; i++) {
            R[i] = Integer.parseInt(buff.readLine().trim());
        }

        int candies = 0;
        int prev = 0;
        int decline = 0;
        for (int i = 1; i < R.length; i++) {
            // Strictly increasing
            if (R[i] > R[i-1]) {
                prev++;
                candies += prev;
                continue;
            }
            // Strictly decreasing
            if (R[i] < R[i-1]) {
                decline ++;
                continue;
            }
            // Lateral change
            if (R[i] == R[i-1]) {
                prev = 1;
                candies++;
            }
        }
        System.out.println(candies);
    }
}
