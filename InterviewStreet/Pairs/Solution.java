/*
 Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
*/

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader buff = new BufferedReader(new FileReader("tests.txt"));
        //int num_tests = Integer.parseInt(buff.readLine().trim());
        //for (int i = 0; i < num_tests; i++) {
            String[] arr = buff.readLine().trim().split(" ");
            int diff = Integer.parseInt(arr[1]);
            arr = buff.readLine().trim().split(" ");
            int[] nums = new int[arr.length];
            HashSet<Integer> table = new HashSet<Integer>();
            int index = 0;
            for (String val : arr) {
                nums[index] = Integer.parseInt(val);
                table.add(nums[index]);
                index++;
            }
            int count = 0;
            for (Integer val : table) {
                if (table.contains(val-diff)) {
                    count++;
                }
            }
            System.out.println(count);
        //}
    }
}
