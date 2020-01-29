/* Name: Samreen Azam
 * CourseGrades.java
 * Period 6 */

import java.util.*;
import java.io.*;
public class CourseGrades
{
  public static void main(String args[])
  {
    GradeBook x = new GradeBook();
    x.getGrades();
    System.out.println("Student Grades:");
    
    x.showGrades();
    
   System.out.println("Input Student Number: 1, 2, or 3 ---> ");
   Scanner kbReader = new Scanner(System.in);
   int studentNumber = kbReader.nextInt();
   x.studentAvg(studentNumber);
    
   System.out.println("Input Test Number: 1 or 2 ---> ");
   int testNumber = kbReader.nextInt();
   x.testAvg(testNumber);
   kbReader.close();
   
  
  }
}