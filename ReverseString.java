import java.util.Scanner;
import java.util.StringTokenizer;

public class ReverseString {
    public static String reverseWords(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        StringBuilder builder = new StringBuilder() ;
        while (tokenizer.hasMoreTokens()) {
            String tokeString = tokenizer.nextToken();
            builder.append(reverse(tokeString)).append(" ");
        }
        return builder.toString().substring(builder.toString().length()-1);
    }

    public static String reverse(String s){
        char [] str = s.toCharArray();
        StringBuilder builder = new StringBuilder() ;
        for (int i = str.length-1; i >=0; i--) {
            builder.append(str[i]);
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(reverseWords(sc.nextLine()));
    }
}
