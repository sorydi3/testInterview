import java.util.Scanner;

public class Satisfiability {

    private static Integer []parents;

    public static boolean equationsPossible(String[] equations) {
        parents = new Integer[26];

        //init parents to be parents to itselfs
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }

        //go throught to all equations/nodes 
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if(isEquality(equation)){ // check if "=="  ||| 97='a'
                int indexval1 = getParent(equation.charAt(0)-97);  // get the index of the char in parents
                int indexval2 = getParent(equation.charAt(3)-97);  // get the index of the char in parents
                if(indexval1!=indexval2) parents[indexval1]=indexval2; // unify both edges
            }
        }

        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if(!isEquality(equation)){ // check if "!="  ||| 97='a'
                int indexval1 = getParent(equation.charAt(0)-97);  // get the index of the char in parents
                int indexval2 = getParent(equation.charAt(3)-97);  // get the index of the char in parents
                if(isContradiction(indexval1,indexval2)) return false; // unify both edgese
            }
        }
        return true;
    }

    private static int getParent(int i) {
        if(parents[i]==i) return i;
        return getParent(parents[i]);
    }

    public static boolean isEquality(String curr){
        return curr.charAt(1)=='=';
    }

    public static boolean isContradiction(Integer indexval1,Integer indexval2){
        return indexval1==indexval2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []arr = {"a==b","a==a","x==b","x!=a"};
        System.out.println(equationsPossible(arr));
    }
}
