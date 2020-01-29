/* Samreen Azam
 * Date: 10/6/17
 * AP CS A
 * Period 6 */

import java.util.*;
public class LunchTime
{
  public static int minutesUntilLunch(int hours, int minutes) //takes in the hour & minute and calculates how long until 1 pm
  {
    int hrsToMin = (13 - hours)*60; //1 pm = 13:00, so subtract the hour by 13 and multiply by 60 to get minutes
    int mins = 60 - minutes; 
    mins = hrsToMin - minutes;
    return mins;
  }
  public static void main(String args[])
  {
    System.out.println("Enter current time (hh:mm) ");
    Scanner kbReader = new Scanner(System.in); 
    String currentTime =  kbReader.nextLine();
    int x = currentTime.indexOf(":"); //to separate hour and minute
    int hr = Integer.parseInt(currentTime.substring(0, x));  //converts substring of the hour to an integer
    int min = Integer.parseInt(currentTime.substring(x+1));  // converts substring of number of minutes to an integer
    int time = minutesUntilLunch(hr, min);
    System.out.println("You have " + time + " minutes left until lunch!");
    kbReader.close();
  }
}