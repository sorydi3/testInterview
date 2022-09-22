import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Candies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = maxCandies(candies);
        List<Boolean> list =  new ArrayList<>();
        for (int index = 0; index < candies.length; index++) {
            int aux = candies[index];
            int sum = aux+extraCandies;
            if(sum>=max) list.add(true);
            else list.add(false);
        }
        return list;
    }
    
    public static int maxCandies(int[] kids){
        int max = 0;
        for(int i = 0;i<kids.length;i++){
            int aux = kids[i];
            if(aux>max) max=aux;
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] list = {1,4,5};
        System.out.print(kidsWithCandies(list,3)); 
    }
}
