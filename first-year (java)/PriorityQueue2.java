import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cole on 11/6/16.
 * Edited by Sarah on 11/17/17.
 */
public class PriorityQueue2 {

    private ArrayList<Integer> pQueue;

    public PriorityQueue2(){
        pQueue = new ArrayList<>();
    }

    public boolean isEmpty(){
        return pQueue.isEmpty();
    }

    public void insert(int num){
        if(pQueue.isEmpty()){
            pQueue.add(num);
        } else {
            int size = pQueue.size();
            for(int i = 0; i < size; i++){
                if(pQueue.get(size - 1) < num){
                    pQueue.add(num);
                    break;
                } else if(pQueue.get(i) > num && i == 0){
                    pQueue.add(0, num);
                    break;
                } else if (pQueue.get(i) > num){
                    pQueue.add(i , num);
                    break;
                }
            }
        }
    }

    public int remove(){
        if(pQueue.isEmpty()){
            System.out.println("The priority queue is empty. Return value is 0");
            return 0;
        } else {
            int max = pQueue.get(pQueue.size() - 1);
            pQueue.remove(pQueue.size() - 1);
            return max;
        }
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

    }
}