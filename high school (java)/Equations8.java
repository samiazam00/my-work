/* Samreen Azam
 * AP CS A (Period 6)
 * Quadratic Equation Program
 * Chapter 9, Question 8 */

import java.util.Scanner;
public class Equations8
{
  public static String [] quadSolver(double a, double b, double c) //takes in 3 integers to solve quadratic equation, returns String array
  {
    double d = (Math.pow(b, 2)) - (4*a*c); //discriminant
    String roots[] = new String [2];
    
    if(a == 0 && b == 0 && c == 0) //all are 0, throw exception
    {
      throw new IllegalArgumentException ("a = b = c = 0");
    }
    
    else if (b == 0 && c != 0)
    {
      roots[0] = null; 
    } 
    
    else if(a == 0 && b != 0)  
    {
      roots[0] = Double.toString((-c)/b);
    }
    
    else if(d > 0) //indicates that there are 2 real roots
    {
      roots[0] = Double.toString(((-b) - (Math.sqrt(d))) / (2*a)); //add discriminant
      roots[1] = Double.toString(((-b) + (Math.sqrt(d))) / (2*a)); //subtract d
    }
    
    else if(d == 0) //only one real root
    {
      roots[0] = Double.toString((-b) / (2*a));
      roots[1] = Double.toString((-b) / (2*a));
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
    if(solution[1] == null)
      System.out.println("a, b, c = " + aa + ", " + bb + ", " + cc + ": root(s) = " + solution[0]); 
    
    else
      System.out.println("a, b, c = " + aa + ", " + bb + ", " + cc + ": root(s) = [" + solution[0] + ", " + solution[1] + "]"); 
    
  }
}