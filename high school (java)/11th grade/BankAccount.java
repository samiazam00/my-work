/* Azam, Samreen
 * Period 6 SL
 * 10/12/16
 * Pledge: Samreen Azam */

 public class BankAccount 
 {
   double balance;
   String name;
   double money;
   
  public BankAccount(double b, String n)
  {
    balance = b;
    name = n; 
  }
  
  public void deposit(double money)
  { 
    balance = balance + money;
  }
  public void withdraw(double money)
  {
    balance -= money;
  }

    
 }
  
