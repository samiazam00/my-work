/* Samreen Azam
 * AP CS A
 * Period 6 */
public class ModFib
{
  /* Preconditions - modFibonacci has 1 int parameter
   * Postconditions - returns an integer (sum of last 3 modified Fibonacci numbers)
   * Actions - if the passed integer is not 0, 1, or 1, a base case hasn't been reached & method calls itself */
  public static int modFibonacci(int n)
  {
    switch (n) //use switch statement for the 3 base cases & recursive case (default) 
    {
      case 0: 
        return 3; //if n = 0, return 3
      case 1: 
        return 5;
      case 2: 
        return 8; 
      default: //recursive case
        return modFibonacci(n - 1) + modFibonacci(n -2) + modFibonacci(n-3); //Recursively adds the last 3 modified Fibonacci numbers  
    }  
  }
}