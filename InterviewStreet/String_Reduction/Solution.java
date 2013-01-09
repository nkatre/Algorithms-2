/*
 *  Solution to the String Reduction InterviewStreet challenge.
 *
 *  Approach: Dynamic programming solution which checks all
 *  possible collapse options recursively.
 *
 *  @author Sanjay Paul
 *  @date 01.02.2013
 */

import java.util.*;
import java.io.*;

public class Solution {
    static HashMap<String, Integer> minSizeMap;

    private static char[] collapse(int i, char[] arr) {
        char replace = (char)(294 - (int)(arr[i]) - (int)(arr[i+1]));
        char[] output = new char[arr.length-1];
        for (int j = 0; j < i; j++) {
            output[j] = arr[j];
        }
        output[i] = replace;
        for (int j = i+2; j < arr.length; j++) {
            output[j-1] = arr[j];
        }
        return output;
    }

    private static int recurse (char[] arr) {
        String str = new String(arr);
        if(minSizeMap.containsKey(str))
            return (int)minSizeMap.get(str);
        int size = arr.length;
        char[] next = new char[arr.length-1];
        for(int i=0; i<arr.length-1; i++) {
            if (arr[i] != arr[i+1])
                size = Math.min(size, recurse(collapse(i,arr)));
        }
        minSizeMap.put(new String(arr),size);
        return size;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("tests.txt"));
        //BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        
        minSizeMap = new HashMap<String, Integer>();
        int num_tests = Integer.parseInt(buff.readLine().trim());
        for (int i = 0; i < num_tests; i++) {
            System.out.println(recurse(buff.readLine().trim().toCharArray()));
        }
    }
}
