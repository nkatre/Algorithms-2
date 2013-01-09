import java.lang.*;

class IntegerParserTest {
    
    public static void main(String args[]) {
        for (int i = 0; i < 1000; i++) {
            int val = (int)(Math.random()*(Integer.MAX_VALUE/2));
            StringBuffer buff = new StringBuffer();
            buff.append(val);
            if(IntegerParser.atoi(buff.toString()) != val)
                System.err.println("Failed");
        }
        System.out.println("done");
    }
}
