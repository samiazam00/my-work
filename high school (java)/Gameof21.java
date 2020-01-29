/* Pledge: Samreen Azam
 * 9/14/17
 * AP Computer Science A 
 * Period 6 */

import java.util.*;
public class Gameof21
{ 
  public static void startGame() 
  {
    Player letsPlay = new Player();
    Player secondCard = new Player();
    PlayingCard winner = new PlayingCard();
    int first = letsPlay.youDraw();
    int sec = secondCard.youDraw();
    
    int comp1 = letsPlay.computerDraws();
    int comp2 = secondCard.computerDraws(); 
   
    winner.aces(first, sec);
    winner.aces(comp1, comp2);
    
    int compsum = comp1 + comp2;
    int sum = first + sec;
        
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Would you like a third card? (Y/N):");
    String anotherCard = kbReader.nextLine();
    char cardChoice = anotherCard.charAt(0);
    
    switch(cardChoice)
    {   
      case 'Y':
      case 'y':
        int thirdCard = letsPlay.youDraw();
        sum += thirdCard;
        if(thirdCard == 1 && (sum + 11 <= 21))
           sum += 10;
           break;
      case 'N':
      case 'n':
        if(compsum < sum) 
        {
          int kard = letsPlay.computerDraws();
          compsum += kard;
         }
        break;
      default:
        System.out.println("Please type 'Y' for yes or 'N' for no!");
    }
    
    winner.whoWon(sum, compsum);
    
    kbReader.close();
  }
  
  public static void playAgain()
  {
    System.out.println("Would you like to play another round? (Y/N):"); 
    Scanner kbReader = new Scanner(System.in);
    String yesorno = kbReader.nextLine();
    char yn = yesorno.charAt(0);
    
    switch(yn) 
    {
      case 'Y':
      case 'y':
        startGame();
        playAgain();
        break;
      case 'N':
      case 'n':
        System.out.println("Thanks for playing!");
        break;
      default:
        System.out.println("Please type 'Y' for yes or 'N' for no!");
        
        kbReader.close();
    }
  } 
  
  public static void main (String args[])
  {
    startGame();
    playAgain();
  }
 }