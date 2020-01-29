/* Samreen Azam
 * AP CS A
 * Period 6 */

import java.util.Scanner;
public class DivideBy3
{
  /* Precondition - has 1 int parameter: sum of digits of number the user chose (calls sumDigits)
   * Postcondition - Returns a boolean 
   * Actions -  returns true is number's sum is divisble by 3, false if it is not */
  public static boolean isDivisibleBy3(int n)
  {
    if (n < 10) 
    {
      return n == 3 || n == 6 || n == 9; //Base case: true if number is divisible by 3
    }
    else
    {
      return isDivisibleBy3(sumDigits(n)); //Recursive case: calls itself to check if sum can be divided by 3
    }
  }
  
  /* Precondition - has 1 int parameter  
   * Postcondition - Returns an int (sum of all digits)
   * Actions - Calclates the sum of each digit in the integer passed to method */
  public static int sumDigits(int digit)
  {  
    if (digit < 10) //base case: if there is only 1 digit in the number,
    {
      return digit; //return the number because its sum will be itself
    }
    else //recursive case: more than 1 digit
    {
      return sumDigits((digit / 10) + (digit % 10)); //Calls itself to add the next digit
    }
  } 
  
  public static void main(String args[])
  {
    System.out.println("Enter an integer: ");
    Scanner kbReader = new Scanner(System.in);
    int input = kbReader.nextInt();
    System.out.println("The nuber " + input + " is divisible by 3: " + isDivisibleBy3(input)); 
  }
}