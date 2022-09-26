import java.util.Scanner;

public class Satisfiability {

    public static boolean equationsPossible(String[] equations) {
        
        boolean found =  false;

        int i = 0;
        while (i<equations.length-1 && !found) {
            if(!isBothEqual(equations[i])){
                String curr = equations[i];
                for (int j = i+1; j < equations.length; j++) {
                    if(isContradiction(curr, equations[j])){
                        found=true;
                        break;
                    }
                }
            }
            i++;
        }
        
        return !found;
    }

    public static boolean isBothEqual(String curr){
        return curr.charAt(0)==curr.charAt(curr.length()-1);
    }

    public static boolean isContradiction(String curr,String i){
        if(isVariablesNamesEquals(curr, i)){
            return ! curr.substring(1,2).equals(i.substring(1,2));
        }
        return false;
    }

    public static boolean isVariablesNamesEquals(String curr,String i){

        /**
         * check if the last characters of the strings are equal
         * ex a==b && a==b yeald true similarly for b==a a==b also yield true
         */
        return curr.charAt(0)==i.charAt(0) && curr.charAt(curr.length()-1)==i.charAt(i.length()-1) 
        
        ||

        curr.charAt(0)==i.charAt(i.length()-1) && i.charAt(0)==curr.charAt(curr.length()-1);
 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []arr = {"a==b","a==a","x==b","x!=a"};
        System.out.println(equationsPossible(arr));
    }
}
