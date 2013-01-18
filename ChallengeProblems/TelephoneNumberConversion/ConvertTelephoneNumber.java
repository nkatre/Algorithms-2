import java.util.*;

public class ConvertTelephoneNumber {
    public static final char[][] conversions = {{'a','b','c'},{'d','e','f'},{'g','h','i'},
            {'j','k','l'},{'m','n','o'},{'p','q','r'},{'s','t','u'},
            {'v','w','x'},{'y','z'}};
    
    // Should refactor using LinkedList
    public static List<String> convert(int number) {
        String str = ""+number;
        char[] arr = str.toCharArray();
        if (Arrays.asList(arr).contains('0'))
            return new ArrayList<String>();
        Set<StringBuffer> set = new HashSet<StringBuffer>();
        int first_digit = (int)(arr[0]) - 48;
        for (char chr : conversions[first_digit - 1]) {
            set.add(new StringBuffer(chr));    
        }
        for (int i = 1; i < arr.length; i++) {
            Set<StringBuffer> nextSet = new HashSet<StringBuffer>();
            for (StringBuffer buff : set) {
                int digit = (int)(arr[i]) - 48;
                for (char chr : conversions[digit-1]) {
                    StringBuffer tmp = new StringBuffer(buff.toString());
                    tmp.append(chr);
                    nextSet.add(tmp);
                }
            }
            set = nextSet;
        }
        List<String> output = new ArrayList<String>(set.size());
        for (StringBuffer buff : set)
            output.add(buff.toString());
        return output;
    }
}
