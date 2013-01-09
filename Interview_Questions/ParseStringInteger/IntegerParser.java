/*
 * Given an input String representing an integer,
 * return an int value.
 *
 * Approach: Mostly straightforward. Tricky parts
 * arise in dealing with edge cases and the possibility
 * of negative values. With the latter, it becomes
 * impossible to indicate failure (right now it returns
 * a -1, but the more sensible approach would be to 
 * raise an exception rather than allow clients to screw
 * themselves over).
 *
 */

class IntegerParser {
    
    public static int atoi(String str) {
        if (str==null || str.isEmpty()) return -1;
        char[] arr = str.toCharArray();
        int mult = 1;
        int result = 0;
        int offset = (arr[0] == '-') ? 1 : 0;

        try {
            for (int i = arr.length-1; i >= offset; i--) {
                result += mult * ((int)(arr[i]) - 48);
                mult *= 10;
            }
            if (offset==1)
                result *= -1;
        }
        catch (Exception e) {
            System.err.println("Integer contains illegal characters or" +
            "cannot be parsed because it is outside the representable range.");
            return -1;
        }

        return result;
    }

