/*
 * Solution to Play on Words SPOJ challenge.
 *
 * Approach: Requires something of dynamic programming approach
 * except that this has to somehow compensate for the possibility
 * of a repetition.
 *
 * @author Sanjay Paul
 * @date 12.25.2012
 */
import java.io.*;
import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        //BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buff = new BufferedReader(new FileReader("tests.txt"));

        int numTests = Integer.parseInt(buff.readLine().trim());
        for (int i = 0; i < numTests; i++) {
            int numWords = Integer.parseInt(buff.readLine().trim());

            boolean[] used = new boolean[numWords];
            HashMap<String, LinkedList<Integer>> firstLetterMap 
                = new HashMap<String, LinkedList<Integer>>();
            HashMap<String, LinkedList<Integer>> lastLetterMap 
                = new HashMap<String, LinkedList<Integer>>();
            for (int j = 0; j < numWords; j++) {
                firstLetterMap.add( 
            }
        }
    }
}
