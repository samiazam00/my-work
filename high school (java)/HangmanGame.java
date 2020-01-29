/* Samreen Azam
 * AP CS A (Period 6)
 * Chapter 8 Question 21 (Summative)
 * HangmanGame Class
 */

public class HangmanGame 
{
  private static String answer = "";
  private static StringBuffer guesses;
  private static StringBuffer tries = new StringBuffer("");
  public HangmanGame(String rightAnswer)     //constructor: after choosing a random word from main class, answer will be
  {                                         //set to the right word to be guessed when construtor is called  
    answer = rightAnswer.toUpperCase();    //both user input & the answer word set to upper case (it looks better,
                                          //and user can input lower case for same result)
    guesses = new StringBuffer(answer);  //guesses will equal the answer word for now
    
    for(int x = 0; x < answer.length(); x++)    //for loop adds a dash for each letter of answer
      guesses.setCharAt(x, '-');               //setCharAt method replaces letter at index x with a dash 
 
  } 
 
  public String getWord() //accessor method: returns the answer word
  {
    return answer;
  }
  
  public String getGuessed() //converts into string, returns string of correct guesses w/ dashes for letters not yet guessed
  {
    return guesses.toString();
  }
  
  public String getTried() //converts into string, returns string of the letters guessed so far (no duplicates)
  {
    return String.valueOf(tries);
  }

  public int tryLetter(char letter) //this method takes in the char the user guesses & checks if it is in the word or has been guessed yet
  {
    if(tries.toString().indexOf(letter) >= 0) //(StringBuffer class does not contain ".indexOf" method for char parameters, so we    
      return 0;                               //convert it to a String.) If it does not return a -1, then it was found in the string.
       
    tries.append(letter);     //letter is added to string containing what letters have been tried
    
    if(answer.indexOf(letter) >= 0) {
      for(int i = 0; i < answer.length(); i++)    //for loop goes through word to replace dashes with guessed letters
      {
        if(answer.charAt(i) == letter) //if letter is in word at the index of i
          guesses.setCharAt(i, letter); //replace the "-" with the letter at position i 
      }
      return 1; //break out, return 1 to confirm it is in answer word
    }
  else
    return -1; //otherwise, return -1 to indicate it was an incorrect guess
  }
  
}