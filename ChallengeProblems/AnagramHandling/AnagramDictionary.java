/*
 * A collection mapping specifically designed to hold anagrams.
 */

import java.util.*;

public class AnagramDictionary {

    private final HashMap<String, TreeSet<String>> dict;

    public AnagramDictionary() {
       dict = new HashMap<String, TreeSet<String>>(); 
    }

    public AnagramDictionary(Collection<String> c) {
        dict = new HashMap<String, TreeSet<String>>();
        for (String str : c)
            dict.add(str);
    }

    // Add a new String to the corresponding anagram set
    // in the dictionary.
    public boolean add(String str) {
        if (str==null || str.isEmpty()) return false;
        String sorted = sortString(str);
        if (!dict.containskey(sorted))
            dict.put(sorted, new TreeSet<String>());
        dict.get(key).add(str);
        return true;
    }

    // Retrieves stored anagrams for the
    // given word. NOTE: can include the
    // input word itself.
    public Set<String> getStoredAnagrams(String str) {
        if (str==null || str.isEmpty()) 
            return new TreeSet<String>();
        Set<String> output = dict.get(str);
        if (output==null)
            return new TreeSet<String>();
        return output;
    }

    // This is abstracted out to a separate 
    // method to allow for future improvements.
    // In particular, it might be useful to
    // implement a String version of Radix sort
    // to boost efficiency.
    private String sortString(String str) {
        char[] arr = str.toCharArray();
        return (new String(Arrays.sort(arr)));
    }
}
