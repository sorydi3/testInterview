import java.util.*; 
import java.io.*;
import java.time.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
public class sollersTest {

    public static String StringChallenge(String str) {
        String [] parts = str.split("-");
        String start = parts[0];
        String end = parts[1];

        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("hh:mm a");
    
        LocalTime starttime = LocalTime.parse(formatS(start),formatter);
        LocalTime endtime = LocalTime.parse(formatS(end),formatter);
    
    
        Duration duration = Duration.between(starttime,endtime);
    
    
        return String.valueOf(Math.abs(duration.toMinutes()));
      }
    
      public static String formatS(String date){
        String a = date.substring(date.length()-2).toUpperCase();
        String str = date.substring(0,date.length()-2).concat(" ").concat(a);
        return str;
      }
    
      //12:30pm-12:00am
      public static void main (String[] args) {  
        // keep this function call here     
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine())); 
      }

      
    
}