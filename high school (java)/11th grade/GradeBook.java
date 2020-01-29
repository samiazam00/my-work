/* Name: Samreen Azam
 * GradeBook class
 * Period 6 */

import java.util.*;
import java.io.*;

public class GradeBook
{
 public GradeBook()
 {}
 int grades[][] = new int[3][2];
  
 public void getGrades()
 { 
   System.out.println("Enter Test Score 1 for Student 1: ");
   Scanner kbReader = new Scanner(System.in);
   grades[0][0] = kbReader.nextInt();
   System.out.println("Enter Test Score 2 for Student 1: ");
   grades [0][1] = kbReader.nextInt();

   System.out.println("Enter Test Score 1 for Student 2: ");
   grades[1][0] = kbReader.nextInt();
   System.out.println("Enter Test Score 2 for Student 2: ");
   grades[1][1] = kbReader.nextInt();
   
   System.out.println("Enter Test Score 1 for Student 3: ");
   grades[2][0] = kbReader.nextInt();
   System.out.println("Enter Test Score 2 for Student 3: ");
   grades[2][1] = kbReader.nextInt();

   kbReader.close();
 }
 
 public void showGrades()
 {
   System.out.println(" \t1 \t2");
   System.out.println("1\t" + grades[0][0] + "\t" + grades[0][1]);
   System.out.println("2\t" + grades[1][0] + "\t" + grades[1][1]);
   System.out.println("3\t" + grades[2][0] + "\t" + grades[2][1]);
 }
 
public void studentAvg(int stu)
 {
   double avg = (((grades[stu - 1][0]) + (grades[stu - 1][1]))/2.0);
   
   if(stu == 1)
     System.out.println("The average for student 1 is: " + avg);
   if(stu == 2)
     System.out.println("The average for student 2 is: " + avg);
   if(stu == 3)
     System.out.println("The average for student 3 is: " + avg);
 }

public void testAvg(int test)
 { 
   double testAvg = (((grades[0][test - 1]) + (grades[1][test - 1]) + (grades[2][test - 1]))/3.0);   
   
   if(test == 1)
     System.out.print("The average test 1 is: " + testAvg);
   if(test == 2)
     System.out.print("The average for test 2 is: " + testAvg);
 }
}