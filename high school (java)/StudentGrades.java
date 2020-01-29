/* Samreen Azam
 * AP CS A Period 6
 * Student Grades Program */

import java.util.Scanner;
public class StudentGrades
{
  public static void main (String args[])
  {
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Please enter the number of courses you completed this year.");
    int len = kbReader.nextInt();
    int grades[] = new int[len]; //array for grades (integers)
    String courses[] = new String[len]; //array for course names (Strings)
    
    for(int indx = 0; indx < len; indx++) //loop to initialize elements of both arrays
    {
      System.out.println("Please enter a course name.");
      courses[indx] = kbReader.next();
      System.out.println("What grade did you recive in " + courses[indx] + "? Enter an integer.");
      grades[indx] = kbReader.nextInt();
    }
    System.out.print("You are eligble for a high achievement award in the following classes: ");
    for(int k = 0; k < len; k++) //traverse & check for grades higher than a 93
    {
      if(grades[k] > 93)
        System.out.print(" " + courses[k] + " (" + grades[k] + ")   ");
    }
    
    System.out.print("\nYou need to improve in the following classes: ");
    for(int j = 0; j < len; j++) //traverse & check for grades lower than 70
    {
      if(grades[j] < 70)
        System.out.print(" " + courses[j] + " (" + grades[j] + ")   ");
    }

    kbReader.close();
  }
}