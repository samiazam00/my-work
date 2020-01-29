/* Samreen Azam
 * HL Period 2
 * Data Analysis Summative Program */

import java.io.*;
import java.util.*;
public class DataAnalysis
{
  private static int numDaysInMonth (String month, int year) //parameters are a string & integer for the month & year
  {                                                          //returns int for the # of days in the month of that year
    if(month.equals("September") || month.equals("November") || month.equals("June") || month.equals("November"))
      return 30;
    else if(month.equals("February"))
    {
      if(year % 4 == 0) //if it is a leap year (every 4 years)
        return 29;      //there are 29 days in Feb. instead of 28
      else
        return 28;
    }
    else
      return 31;
  } 
  
  private static int calculateAverage(int[] temp) //parameter is an int array, returns integer of the average of all values in the array 
  {
    double total = 0;
    double length = temp.length; //must declare a double for when finding average later on
    for(int maxIndx = 0; maxIndx < length; maxIndx++) //increment index each time to go through array
    {
      total += temp[maxIndx]; //adds each temperature value to total sum
    }
    int average = (int) Math.round(total/length); //sometimes may result in a long, so cast to an int
    return average;
  }
  
  private static double calculateSum(double[] rainfall) //parameter is a double array, calculates sum of all rainfall values & returns double
  {
    double sum = 0;
    for(int rainIndx = 0; rainIndx < rainfall.length; rainIndx++) //increment index each time to go through array
    {
      sum += rainfall[rainIndx]; 
    }
    return Math.round(sum * 10) / 10.0; //can't just return sum: multiiply & divide by 10 to round to one decimal
  }  
  
  public static String enterFile() //enter name of input file, returns string to be passed to method for reading contents of file
  {
    Scanner kbReader = new Scanner(System.in);                                 
    System.out.println("Input File Name (Include File Extension):");
    String inputName = kbReader.nextLine();
    if(!inputName.contains("."))
    {
      System.out.println("Please add the file extension before proceeding (Example: '.txt')");
      inputName = enterFile();
    }
    kbReader.close();
    return inputName;
  }
  public static void readAndStoreData(String in) throws IOException //parameter is a strings for input file name, void return type
  {                                                                //allows user to enter name of file to read & store output to another file
    Scanner kbReader = new Scanner(System.in);
    System.out.println("Output File Name:");
    String outputName = kbReader.nextLine();      
    if(!outputName.contains("."))    //if user does not add file extension, the output file format becomes .txt
      outputName = outputName + ".txt";
    try    //try-catch used in case file is not found
    {
      Scanner inputReader = new Scanner(new File(in));
      String x = inputReader.nextLine();  //reads header row
      int yr = Integer.parseInt(x.substring(0, x.indexOf("\t")));   //creates substring for the year, converts to int
      String mnth = x.substring((x.indexOf("\t")+1), x.lastIndexOf("\t"));  //creates substring for the month
      String city = (x.substring(x.lastIndexOf("\t"))).trim();  //creates substring of the city name
      
      FileWriter fw = new FileWriter(outputName); 
      PrintWriter output = new PrintWriter(fw);  //will store information to output file named by user
      
      int days = numDaysInMonth(mnth, yr); //calls method to determine how many days, will pass arguments of mnth ("September") and yr (2017)
      System.out.println("For the month of " + mnth + " " + yr + " in " + city + ":");
      output.println("For the month of " + mnth + " " + yr + " in " + city + ":");
      
      int highTemps[] = new int[days]; //array for high temperaturs, # of elements equal to # of days
      for(int indx = 0; indx < highTemps.length; indx++)
      {
        String h = inputReader.nextLine();
        int k = h.indexOf("\t") + 1;
        String sub = h.substring(k, (h.indexOf(("\t"), k)));
        highTemps[indx] = Integer.parseInt(sub);
      }
      int highAvg = calculateAverage(highTemps);
      System.out.println("The average high temperature was " + highAvg + " degrees.");
      output.println("The average high temperature was " + highAvg + " degrees.");
      inputReader.close(); 
      
      Scanner lowReader = new Scanner(new File(in)); //new scanner to read from top of file again, this one specifically for lowTemps
      int lowTemps[] = new int[days];   //array for low temperatures
      lowReader.nextLine();   //ignore the header row since it has already been read
      for(int indx2 = 0; indx2 < days; indx2++)
      {
        String lowNums = lowReader.nextLine();
        int lastTab = lowNums.lastIndexOf("\t");
        int midTab = lowNums.lastIndexOf(("\t"), lastTab) - 2;
        String lowSub = (lowNums.substring(midTab, lastTab)).trim();
        lowTemps[indx2] = Integer.parseInt(lowSub);
      }
      int lowAvg = calculateAverage(lowTemps);
      System.out.println("The average low temperature was " + lowAvg + " degrees.");
      output.println("The average low temperature was " + lowAvg + " degrees.");
      lowReader.close();
      
      Scanner rainReader = new Scanner(new File(in)); //new scanner to read for rainfall amounts
      double rain[] = new double[days]; //array for rainfall amounts
      rainReader.nextLine(); //ignore headers again
      for(int indx3 = 0; indx3 < days; indx3++)
      {
        String rainNums = rainReader.nextLine();
        String rainSub = rainNums.substring((rainNums.lastIndexOf("\t")));
        rain[indx3] = Double.parseDouble(rainSub);
      }
      double rainSum = calculateSum(rain);
      System.out.println("The total rainfall was " + rainSum + " inches.");
      output.println("The total rainfall was " + rainSum + " inches.");
      rainReader.close();
      
      
      for(int y = 1; y <= days; y++) //will print the days, and go through each array to print values
      {                            // "+" means temp is above average, "-" means below. "*" means rainfall > 0.00 inches
       System.out.print(y + "\t" + highTemps[y-1]);
       output.print(y + "\t" + highTemps[y-1]);
       
       if(highTemps[y-1] < highAvg)
       {
         System.out.print("-");
         output.print("-");
       }
       else if(highTemps[y-1] > highAvg)
        {
         System.out.print("+");
         output.print("+");
       }
       
       System.out.print("\t" + lowTemps[y-1]);
       output.print("\t" + lowTemps[y-1]);
       
       if(lowTemps[y-1] < lowAvg)
       {
         System.out.print("-");
         output.print("-");
       }
       else if(lowTemps[y-1] > lowAvg)
       {
         System.out.print("+");
         output.print("+");
       }
       
       if(rain[y-1] > 0.00)
       {
         System.out.println("\t" + rain[y-1] + "*");
         output.println("\t" + rain[y-1] + "*");
       }
       else
       {
         System.out.println("\t" + rain[y-1]);
         output.println("\t" + rain[y-1]);
       }
      }
      System.out.println("\nWould you like to run this program again? (Y/N)");
      loopProgram();
      output.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println("Your file was not found. Please try again."); 
      String tryAgain = enterFile();
      readAndStoreData(tryAgain);
    }    
    kbReader.close();
  }
  
  private static void loopProgram() throws IOException //void return type & accepts no parameters 
  {                                                    //purpose is to loop program if user wishes to, or quit
    Scanner kbReader = new Scanner(System.in);
    String choice = kbReader.nextLine();
    if(choice.equalsIgnoreCase("Y"))
    {
      String userIn = enterFile();
      readAndStoreData(userIn);
    }
    else if(choice.equalsIgnoreCase("N"))
    {
      System.out.println("Goodbye!");
    }
    else 
    {
      System.out.println("Invalid input. Please try again.");
      loopProgram();
    } 
    kbReader.close();
  }
  
  public static void main(String args[]) throws IOException
  {
    System.out.println("Samreen Azam \nHL 2 \nData Analysis\n");
    String userInput = enterFile();
    readAndStoreData(userInput);
  }
}