/* Samreen Azam
 * AP CS A
 * Period 6
 * AirlinePoint Program */

import java.util.ArrayList;
import java.util.Scanner;
public class AirlinePoints
{
  static ArrayList<Integer> points = new ArrayList<Integer>(5);
  static boolean qualify; 
  
  public static void main(String args[])
  {
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Please enter the points earned on your last five trips.");
    
    for(int y = 0; y < 5; y++) //five trips = loop 5 times
    {
      System.out.println("Trip " + (y+1) + ": ");
      Integer value = new Integer(kbReader.nextInt());  //user input becomes Integer object
      points.add(y, value); //object added to the ArrayList
    }
    
      for(int z = 0; z < 5; z++) //loop to traverse ArrayList
      {
        if(points.get(z) <= 1200) //if the value at index z is less than/equal to 1200
        {
          qualify = false; //not qualified
        }
        else
        {
          qualify = true; //user is qualified
          break; //break out of loop: if one trip qualifies already, we don't need to look at rest of AL
        }
    } 
    
    if(qualify == true)
      System.out.println("Congratulations! You qualify for 1000 bonus points.");
    else
      System.out.println("Sorry, you have no trips that qualify for 1000 bonus points.");
    
    
    kbReader.close();
  } 
}