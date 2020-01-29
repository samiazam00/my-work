/*Azam, Samreen
  Date: 11/24/16
  Period 6 SL */

import java.io.*;
import java.util.*;
public class StudentAverages
{
  public static void main(String args []) throws IOException
  {
   Scanner file = new Scanner(new File("StudentScores.in"));
   int maxIndex = -1;
   String students[] = new String[150]; 
   System.out.println("These are the students' scores:");
   while(file.hasNext())
     {
       maxIndex++;
       students[maxIndex] = file.nextLine();
       System.out.println(students[maxIndex]);
     }

   file.close();
   
   file = new Scanner(new File("StudentScores.in"));
   System.out.println("\nHere are the average grades for each student:");
   double sum = 0;
   double counter = 0;
   double avg = 0;
   int x = 0;
   String names = "";
   
    while(file.hasNextLine()) 
    { 
       String line = file.nextLine(); 
       Scanner abc = new Scanner(line);
       names = abc.next();
       System.out.print(names + ", average = ");
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
      }
    file.close();
  }
}