/* Samreen Azam
 * AP CS A Period 6
 * Frequent Letters Program */
import java.util.Scanner;
public class Frequent3Letters
{
  public static void main (String args[])
  {
    System.out.println("Please enter a word that is at least 6 characters.");
    Scanner kbReader = new Scanner(System.in);
    String word = kbReader.nextLine();
    
    while(word.length() < 6) // whiile loop checks word length, keeps going until word is long enough
    {
      System.out.println("This word is too short. Please enter a word that is at least 6 characters.");
      word = kbReader.nextLine();
    }
    
    kbReader.close(); 
    
    char third = word.charAt(2); //find third letter with charAt method
    if(third == 'e' || third == 'E' || third == 's' || third == 'S' || third == 'r' || third == 'R' || third == 'a' || third == 'A')
    {
      System.out.println("Wow! The third letter of " + word + " is " +  third + ", which is a frequent letter!");
    }    
    else
    {
      System.out.println("Sorry! The third letter of " + word + " is " +  third + ", which is NOT frequent letter.");
    }
  } 
}