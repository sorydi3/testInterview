import java.util.*;

public class RomanToInt{

    public static int romanToInt(String s) {
       char [] ch = s.toCharArray();
       Map<Character,Integer> map = buildMap();
         if(ch.length == 1){
             return map.get(ch[0]);
         }

        int count =  0;
        int i = 0;
        while(i < ch.length){
            int next = i+1;
            if(next<ch.length){
                int valb = map.get(ch[i]);
                int vala = map.get(ch[next]);
                if(valb<vala){
                    count+=vala-valb;
                        i+=2;
                }
                else {
                    count+=valb;
                    i++;
                }
            }else{
                count+=map.get(ch[i]);
                i++;
            }
        }
        return count;
    }
    

    public static Map buildMap(){
        Map<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }

    public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(romanToInt(s.nextLine())); 
      }

}