package lab2;

public class CreditCard {
	private Money balance;		//the current balance
	private Money creditLimit;	//the approved credit limit
	private Person owner;		//the owner of the credit card

	//Constructor creates a credit card for the Person parameter
	//with an approved credit limit of the Money parameter
	//and sets the balance to a Money amount of zero 
	public CreditCard(Person newCardholder, Money limit) 
	{
		this.owner = newCardholder;
		this.creditLimit = limit;
		this.balance = new Money(0);
	}
	
	public CreditCard(CreditCard copyCard)
	{
		this.owner = copyCard.owner;
		this.creditLimit = copyCard.creditLimit;
		this.balance = copyCard.balance;
	}

	//Accessor method returns the balance
	public Money getBalance()
	{
		CreditCard a = new CreditCard(this); 
		return a.balance;
	}

	//Accessor method returns the credit limit
	public Money getCreditLimit()
	{
		CreditCard b = new CreditCard(this); 
		return b.creditLimit;
	}

	//Accessor method returns information about the owner
	public String getPersonals()
	{
		CreditCard c = new CreditCard(this); 
		return ("" + c.owner);
	}
	
	//Method to make a charge to the credit card (but only if
	//the credit limit will not be exceeded)
	public void charge(Money amount)
	{
		if(amount.compareTo(creditLimit) != 1)
		{
			balance = balance.add(amount);	
			creditLimit = creditLimit.subtract(amount);
		}
		else
			System.out.println("Exceeds credit limit.");
	}

	//Method to make a payment to the credit card
	public void payment(Money amount)
	{
		balance = balance.subtract(amount);		
	}		

}
