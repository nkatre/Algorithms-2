/*
 * Code to generate all permutations of an input String.
 *
 * @author  Sanjay Paul
 * @date    01.06.2013
 */

import java.util.*;
import java.lang.*;

public class StringPermutations {
    public static Set<String> permute(String str) {
        Set<String> output = new HashSet<String>();
        // Null and Empty Case
        if (str == null || str.equals(""))
            return output;

        // Single Character (Base) Case
        if (str.length()==1) {
            output.add(str);
            return output;
        }
        
        // General Recursive Case
        for (int i = 0; i < str.length(); i++) {
            StringBuffer buff = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {
                if (j != i)
                    buff.append(str.charAt(j));
            }
            for (String str2 : permute(buff.toString())) {
                output.add((Character.toString(str.charAt(i))).concat(str2));
            }
        }
        return output;
    }

    public static void main(String args[]) {
        String test = "abcabbcaba";
        System.out.println("Permuting the string '"+test+"' :\n");
        for (String str : permute(test))
            System.out.println(str);
    }
}
