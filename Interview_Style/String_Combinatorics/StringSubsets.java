/* Code to enumerate all possible substrings of an input String.
 *
 * @author  Sanjay Paul
 * @date    01.06.2013
 */

import java.util.*;

public class StringSubsets {

    public static Set<String> generateAllSubstrings(String str) {
        Set<String> output = new TreeSet<String>();
        // Null and Empty Case
        if (str == null || str.isEmpty())
            return output;

        output.add(str);
        // Single Character Case
        if (str.length()==1)
            return output;

        // General Recursive Case
        for (int i = 0; i < str.length(); i++) {
            StringBuffer buff = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {
                if (j!=i)
                    buff.append(str.charAt(j));
            }
            output.addAll(generateAllSubstrings(buff.toString()));
        }

        return output;
    }
    
    public static void main(String args[]) {
        String test = "abcdef";
        System.out.println("Substrings of '"+test+"':\n");
        for (String str : generateAllSubstrings(test))
            System.out.println(str);
    }
}

