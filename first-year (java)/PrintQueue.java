import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 6 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 6 document.
 * 
 * @author sa3tnc
 *
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

	private LinkedList<String> toPrint;     // the printer's list of documents
	private Lock documentChangeLock;  // a ReentrantLock lock
	private Condition hasPrintTask;   // a condition object
	private boolean isOn;             // boolean variable describing if the queue is on (accepting jobs)

	//TODO:  Handle locking and conditions around the
	//       enqueueing and dequeuing of documents
	//       in this PrintQueue's document list (toPrint)
	//       Note: See the BetterBestBank example in Bank.zip
	//       or in zip folder 'Thread Example 6 - Bank Deadlock' 
	//       on Collab.
	//       Bank.zip:  http://tinyurl.com/cs2110bank

	/**
	 * Constructor
	 */
	public PrintQueue() {
		toPrint = new LinkedList<String>(); // create the list of documents
		isOn = true; // turn on the print queue
		documentChangeLock = new ReentrantLock();
		hasPrintTask = documentChangeLock.newCondition();
	}


	/**
	 * Adds string to the printer queue
	 * implements a lock to ensure that two CardCreators cannot add to the queue at the same time
	 * @param s 
	 */
	public void enqueue(String s) {
		documentChangeLock.lock();
		try
		{
			toPrint.add(s); // add to the list of documents
			hasPrintTask.signalAll(); // Unblock other threads waiting on the condition by "signalAll"
		}
		finally
		{
			documentChangeLock.unlock();
		}

	}

	/**
	 * Removes String at the head of the queue, returns the removed String
	 * Turns off the printer queue if there is nothing left to print
	 */
	public String dequeue() throws InterruptedException{
		documentChangeLock.lock();
		try
		{
			if(toPrint.isEmpty() == false)
			{	
				hasPrintTask.await();
				return toPrint.remove(); // return the first document
			}
			else //Nothing can be removed --> printer can stop
				return null; 
		}
		finally
		{
			documentChangeLock.unlock();
		}
	}

	/**
	 * Set isOn to false so that printer no longer accepts jobs
	 */
	public void turnOff()
	{
		isOn = false;
	}

	/**
	 * isOn is true if PrintQueue is still accepting jobs, false if turned off
	 * @return isOn 
	 */
	public boolean isOn()
	{
		return isOn;
	}

}