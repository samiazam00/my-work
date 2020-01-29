/* Azam, Samreen
 * 10/13/16
 * Period 6 SL */

import java.util.*;
public class Tester
{
  public static void main(String args [])
  {
     
 Scanner kbReader = new Scanner(System.in);
 System.out.println("Please Enter Your Name: ");
 String yourName = kbReader.nextLine();
 System.out.println("Amount of Money You Wish to Deposit: ");
 double swagMoney = kbReader.nextDouble();
 kbReader.close();
 
 BankAccount myAccount = new BankAccount(swagMoney, yourName);
   myAccount.deposit(505.22);
   myAccount.withdraw(100);
 
 System.out.println("The " + yourName + " account balance is, $" + myAccount.balance); 
 
  }

}

