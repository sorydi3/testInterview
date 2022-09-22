import java.util.Scanner;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;

public class longestCommonString {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        char[] prefix = strs[0].toCharArray();
        String foundStr = "";
        boolean found = false;
        StringBuilder buil = new StringBuilder();
        int i = 0;
        while (i < prefix.length && !found) {
            int j = i;
            while (j < prefix.length) {
                buil.append(prefix[j]);
                String aux = buil.toString();   
                found = checkStrings(aux, strs, strs[0]);
                if (found && foundStr.length() < aux.length())
                    if(aux.contains(foundStr) || foundStr.isEmpty() ) foundStr = aux;
                j++;
            }
            
            buil.setLength(0);
            found=true;
            i++;
        }

        return foundStr;
    }

    public static boolean checkStrings(String str, String[] strs, String prefix) {
        boolean found = false;
        int i = 1;

        while (i < strs.length && !found) {
            String aux = strs[i];
            if (!aux.contains(str) || prefix.indexOf(str) != aux.indexOf(str)) found = true;
            i++;
        }
        return !found;
    }

    public static void main(String[] args) {
        // keep this function call here
        // Scanner s = new Scanner(System.in);
        String[] str = new String[] {"babb","caa"};
        System.out.print(longestCommonPrefix(str));
    }
}
