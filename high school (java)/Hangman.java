/* Samreen Azam
 * AP CS A (Period 6)
 * Chapter 8 Question 21 (Summative)
 * Hangman (Main Class)
 */

import java.util.Scanner;
public class Hangman
{
  private static String[] words = {"inheritance", "abstraction", "encapsulation", "polymorphism"};
  private static boolean single;  
  
  public static boolean oneOrTwo() //method returns a boolean, determines if there will be be 1 or 2 players
  {
    Scanner kbReader = new Scanner(System.in);
    try       
    {
      int choice = kbReader.nextInt();
      if(choice == 1)
        single = true;   //single = true, so there is only 1 player
      else if (choice == 2)
        single = false;  //single = false, there are 2 players
      else               //invalid input: asks user to try again
      {
        System.out.println("Invalid input. Please enter a 1 or a 2.");  
        oneOrTwo();
      }
    }
    catch(Exception e)   //asks user to try again in case of an exception, such as an Input Mismatch Exception
    {
     System.out.println("Invalid input. Please enter a 1 or a 2."); 
     oneOrTwo(); 
    }
    kbReader.close();
    return single;
  }
  
  public static void main(String[] args)
  {
    
    System.out.println("Let's play Hangman! The rules are simple: try to guess the hidden word.");
    System.out.println("Type 1 for Single-Player Mode or 2 for Two-Player Mode.");
    Scanner input = new Scanner(System.in);
    
    boolean howMany = oneOrTwo();
    String word; 
    String player;
    if(howMany == true)
    {
      System.out.println("Enter your name: ");
      player = input.nextLine();
      System.out.println("The computer will pick a word for you to guess.");
      word = words[(int)(Math.random() * words.length)];
    }
    else
    { 
      System.out.println("Enter Player 1's name: ");
      String play1 = input.nextLine();
      System.out.println("Enter Player 2's name: ");
      player = input.nextLine();
      System.out.println(play1 + " will enter a word for " + player + " to guess. Don't peek, " + player + "!");
      word = input.nextLine();
    }
    
    HangmanGame game = new HangmanGame(word);
    int count = 0;
    int failedGuesses = 0;

    boolean done = false;
    while (!done)
    {
      System.out.println("\nTried: " + game.getTried());
      System.out.println("Failed guesses: " + failedGuesses);
      System.out.println(game.getGuessed());
      System.out.println();

      System.out.print("Enter next letter (or Quit): ");
      String s = (input.next()).toUpperCase();
      if ("quit".equalsIgnoreCase(s))
        break;
      if (s.length() != 1)
      {
        System.out.println("Invalid input");
      }
      else
      {
        int result = game.tryLetter(s.charAt(0));
        switch(result)
        {
          case 0:

          System.out.println("Already tried");
          break;

          case -1:

          System.out.println("Sorry, not there");
          failedGuesses++;
          break;

          case 1:

          System.out.println("Yes!");
          break;
        }
      }

      count++;

      if (game.getGuessed().indexOf('-') == -1)
      {
        System.out.println("Congratulations, " + player + "! You guessed " + word + " in " + count + " tries.");
        done = true;
      }
    }
    input.close();
  }
}
