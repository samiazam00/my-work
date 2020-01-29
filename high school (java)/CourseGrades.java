/* Samreen Azam
 * HL Period 2
 * CourseGrades.java */

import java.util.*;
public class CourseGrades
{
  public static void main(String args[])
  {
    GradeBook x = new GradeBook();
    x.getGrades();
    System.out.println("Students' Grades:");
    x.showGrades();
    
   System.out.println("Student Average: Please Input Student Number (1, 2, or 3) ");
   Scanner kbReader = new Scanner(System.in);
   int studentNumber = kbReader.nextInt();
   x.studentAvg(studentNumber);
    
   System.out.println("Average Test Grade: Please Input Test Number (1 or 2) ");
   int testNumber = kbReader.nextInt();
   x.testAvg(testNumber);
 
   kbReader.close();
  }
}