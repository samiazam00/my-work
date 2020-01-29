/*Azam, Samreen
  Date: 11/30/16
  Period 6 SL */

import java.io.*;
import java.util.*;
public class StudentAverages_Out
{
  public static void main(String args []) throws IOException
  {
   Scanner file = new Scanner(new File("StudentScores.in"));
   double sum = 0;
   double counter = 0;
   double avg = 0;
   int x = 0;
   String names = "";
   
   FileWriter a = new FileWriter("StudentScores.out");
   PrintWriter xyz = new PrintWriter(a);
   
    while(file.hasNextLine()) 
    { 
       String line = file.nextLine(); 
       Scanner abc = new Scanner(line);
       names = abc.next();
       System.out.print(names + ", average = ");
       xyz.print(names + ", average = ");
           while(abc.hasNext())
            {
             x = abc.nextInt();
             counter++;
             sum += x; 
            }
         avg = (sum / counter);
         System.out.println(Math.round(avg));
         sum = 0; 
         counter = 0;
         abc.close();
         xyz.println(Math.round(avg));
      }
    a.close();
    file.close();
  }
}