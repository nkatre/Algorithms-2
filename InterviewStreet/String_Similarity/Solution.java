/*
* Solution to the String Similarity InterviewStreet Challenge.
*
* Approach: Fairly straightforward with one minor tweak to 
* improve performance: runs of a single character are
* compressed. This will improve the runtime for strings
* with large sequences composed of the same character.
*
* @date 12.25.2012
* @author Sanjay Paul
*/

import java.io.*; 
import java.util.*;

class Solution {

    public static int[] compress(char[] arr) {
        // NOTE: trading space for speed here
        int[] compressed = new int[2*arr.length];
        char curr = arr[0];
        int count = 0;
        int index = 0;
        // Encode each run of a character as a single pair: 
        // (integer value of char, run length).
        for (char c : arr) {
            if (c == curr)
                count++;
            else {
                compressed[index] = (int)curr;
                compressed[index+1] = count;
                index+=2;
                curr = c;
                count = 1;
            }
        }
        
        // Write the last pair
        compressed[index] = (int)curr;
        compressed[index+1] = count;
        // Indicate termination using -1
        compressed[index+2] = -1;
        
        return compressed;
    }
    
    public static int suffix_similarity(int[] arr, int str_len) {
        int count = str_len;
        
        return count;
    }   
        
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        String vals = in.readLine(); 
        int num = Integer.parseInt(vals); 
        for(int x=0;x<num;x++)
        {
               String input = in.readLine();
               char[] arr = input.toCharArray(); 
               System.out.println(suffix_similarity(compress(arr),arr.length)); 
        }
    }   
}
