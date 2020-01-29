/* Samreen Azam
 * AP CS A Period 6
 * Generated Numbers Program */

public class GeneratedNums
{
  public static void main (String args[])
  {
    int nums[] = new int[101]; //declare array with 101 elements 
    int digits;
    int value;
    int store = 0;
    System.out.println("Index\tGenerated Number"); //column headers
    
    for(int x = 0; x < nums.length; x++) //index starts at 0 and increments after each iteration, loop continues until array ends 
    {
      digits = x; //set all numbers to same # as index
      value = x;  
      store = x;  //number to be added to and stored in array
      while(digits > 0) //while loop to check each digit, stops when there are no more digits
      {
        value = digits % 10;  
        digits = digits / 10;
        store += value;
      }    
      nums[x] = store; 
      System.out.println(x + "\t" + nums[x]); //print each index and value under the headers
    }    
  }
}