import java.math.BigInteger;
import java.util.Scanner;


public class ConcatenationBinary1680{
    public static int concatenatedBinary(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <=n; i++) {
         builder.append(Integer.toBinaryString(i));
        }
         return (int) binToIntger(builder.toString()) ;
     }
 
     
     public static long binToIntger(String str){
         char []chr = str.toCharArray();
         BigInteger sum=BigInteger.valueOf(0);
         for (int i = 0  ; i < chr.length ; i++) {
             if(chr[i]=='1'){
                 BigInteger pot = pow(2,chr.length-1-i);
                 sum = sum.add(pot);
             }
         }
         return    sum.mod(BigInteger.valueOf(1000000007)).longValue();
     }
 
     public static BigInteger pow(long base,int exp){
         BigInteger sum = BigInteger.valueOf(1);
         sum = sum.shiftLeft(exp);
         return sum;
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(concatenatedBinary(sc.nextInt()));
    }
}