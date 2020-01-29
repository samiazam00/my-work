/* Samreen Azam
 * HL Period 2
 * GradeBook class */

import java.util.*;

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
 
public void studentAvg(int stud)
 {
   double avg = (((grades[stud - 1][0]) + (grades[stud - 1][1]))/2.0);
   
   if(stud == 1)
     System.out.println("Student 1's average grade is: " + avg);
   if(stud == 2)
     System.out.println("Student 2's average grade is: " + avg);
   if(stud == 3)
     System.out.println("Student 3's average grade is: " + avg);
 }

public void testAvg(int test)
 { 
   double testAvg = (((grades[0][test - 1]) + (grades[1][test - 1]) + (grades[2][test - 1]))/3.0);   
   
   if(test == 1)
     System.out.print("The average for Test 1 is: " + testAvg);
   if(test == 2)
     System.out.print("The average for Test 2 is: " + testAvg);
 }
}