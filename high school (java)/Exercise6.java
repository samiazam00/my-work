/* Samreen Azam
 * AP CS A Period 6
 * Chapter 11 Exercise 6 */

import java.util.ArrayList;
public class Exercise6
{
  public static int findSmallest(ArrayList<Integer> nums) //parameter is Integer ArrayList, returns integer of the smallest value in ArrayList
  {
    int smallest = nums.get(0); //start at first element for smallest
    for(Integer z : nums) 
    {
      if(z.compareTo(smallest) <= 0) //check if element is less than the next one
      {
        smallest = z; //new smallest value
      }        
    }
    return smallest;
  }
  public static void main (String args[])
  {
    int size = 5;
    ArrayList<Integer> numbers = new ArrayList<Integer>(size); 
    for(int indx = 0; indx < size; indx++)
    {
      numbers.add(((int)(Math.random() * (20)))); //randomly initialize elements of ArrayList
    }
    System.out.print("The original array: [");
    for(int y = 0; y < size-1; y++) //traverse and  print original list
    {
      System.out.print(numbers.get(y) + ", "); 
    }
    System.out.println(numbers.get(size-1) +"]"); 
    int min = findSmallest(numbers); //call method to find minimum value
    
    System.out.print("Modified array: [");
    for(int b = 0; b < size-1; b++) 
    {
      if(numbers.get(b) == min)
      {
        numbers.remove(numbers.get(b)); //remove smallest value
        size -= 1; //change the size after removing element
      }
      System.out.print(numbers.get(b) + ", "); 
    }
    System.out.print(numbers.get(size-1) +"]"); 
  }
}