/* Samreen Azam
 * AP CS A (Period 6)
 * Quadratic Equation Program
 * Chapter 9, Question 7 */

import java.util.Scanner;
public class Equations7
{
  public static String [] quadSolver(double a, double b, double c) //takes in 3 integers to solve quadratic equation, returns String array
  {
    double d = (Math.pow(b, 2)) - (4*a*c); //discriminant
    String roots[] = new String [2]; //convert doubles to strings for a string array so that they could be used for same array as null
                                     //(to avoid making multiple arrays, so we can save memory)
    if(a == 0)
    {
      throw new IllegalArgumentException ("a == 0");
    }
     
    else if(d > 0) //indicates that there are 2 real roots
    {
      roots[0] = Double.toString(((-b) - (Math.sqrt(d))) / (2*a)); //add discriminant
      roots[1] = Double.toString(((-b) + (Math.sqrt(d))) / (2*a)); // subtract d
    }
    
    else if(d == 0) //one solution
    {
      roots[0] = Double.toString((-b) / (2*a)); //take out discriminant since it would just add 0, 
      roots[1] = Double.toString((-b) / (2*a)); //there is only one root since both eleents are the same
    }
    
    //if d < 0, there are no real roots, so no change is made (elements are still null)
    
    return roots;
  }
  public static void main (String args[])
  {
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Quadratic Equation Solving");
    System.out.println("Please enter the coefficient values for a, b, and c.");
    System.out.print("a = ");
    double aa = kbReader.nextDouble();
    System.out.print("b = ");
    double bb = kbReader.nextDouble(); 
    System.out.print("c = ");
    double cc = kbReader.nextDouble();
    kbReader.close();
    
    String[] solution = quadSolver(aa, bb, cc);
    if(solution[0] == null)
      System.out.println("a, b, c = " + aa + ", " + bb + ", " + cc + ": root(s) = " + solution[0]); 
    
    else
      System.out.println("a, b, c = " + aa + ", " + bb + ", " + cc + ": root(s) = [" + solution[0] + ", " + solution[1] + "]"); 
    
  }
}