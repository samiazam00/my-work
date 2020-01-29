/* Name: Azam, Samreen
 * Period 6
 * Date Created: 9/29/16
 * Pledge: Samreen Azam */


import java.util.*;
public class Graduation
{
public static void main(String args[])
  {
   
    Scanner kbReader = new Scanner(System.in);
    System.out.print("Enter Your Graduating Grade Point Average: ");
    double g = kbReader.nextDouble();
   
    if(g >= 3.8)
    {
      System.out.println("Congratualtions! You qualify for the distinction of summa cum laude.");
    }
   else if(g >= 3.65)
   {
     System.out.println("Congratulations! You qualify for the distinction of magna cum laude.");
   }
    
       else if(g >= 3.5)
   {
     System.out.println("Congratulations! You qualify for the distinction of cum laude.");
   }
   else if(g <= 3.5)
   {
     System.out.println("You did not qualify for an honors distinction.");
   }
   
   kbReader.close();
 }

}