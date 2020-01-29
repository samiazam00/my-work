import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cole on 11/6/16.
 * Edited by Sarah on 11/17/17.
 */
public class PriorityQueue1 {

	private ArrayList<Integer> pQueue;

	public PriorityQueue1(){
		pQueue = new ArrayList<>();
	}

	public boolean isEmpty(){
		return pQueue.isEmpty();
	}

	public void insert(int num){
		pQueue.add(num);
	}

	public int remove(){
		if(pQueue.isEmpty()){
			System.out.println("The priority queue is empty. Return value is 0.");
		}

		int max = 0;
		int maxIndex = 0;
		for(int i = 0; i < pQueue.size(); i++){
			if(i == 0){
				max = pQueue.get(i);
			} else {
				if(pQueue.get(i) > max){
					maxIndex = i;
					max = pQueue.get(i);
				}
			}
		}
		pQueue.remove(maxIndex);
		return max;
	}

	public ArrayList<Integer> getpQueue() {
		return pQueue;
	}

	public void setpQueue(ArrayList<Integer> pQueue) {
		this.pQueue = pQueue;
	}

	/* This function creates an ArrayList of input data. You may specify the input size and
	 * maximum number in the list. Use this to create data to insert into your PriorityQueue
	 * when testing run time.  
	 * 
	 * Be sure to try multiple input sizes (make sure to test the same size multiple times, 
	 * you might not always get the same result) & multiple maximum numbers. Remember that 
	 * it's especially important to examine the behavior of each method as input grows large! 
	 */
	public ArrayList<Integer> createInput(int size, int maxNum){
		ArrayList<Integer> retVal = new ArrayList<>();
		for(int i = 0; i < size; i++){
			retVal.add(ThreadLocalRandom.current().nextInt(0, maxNum + 1));
		}
		return  retVal;
	}

	// Write your test code in the main method!
	public static void main(String [] args){

		PriorityQueue1 pq = new PriorityQueue1();
		ArrayList<Integer> pqQueue = pq.createInput(50, 9);
		for(int i = 0; i < pqQueue.size(); i++)
		{
			pq.insert(pqQueue.get(i));
			System.out.print(pq.getpQueue().get(i) + "  ");
		}

		long time = System.nanoTime();  // before the method call 
		pq.insert(5);
		System.out.println((System.nanoTime()-time)/1000000000.0); // after the method call
		
		

	}

}