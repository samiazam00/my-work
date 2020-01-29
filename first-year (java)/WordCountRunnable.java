import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable {
	private static int threadCount;
	private static int combinedWordCount; 
    private String filename;
    ReentrantLock wordLock;

    /**
     *  Constructs a WordCountRunnable object with a file name.
     *  @param aFilename the file name that needs to count word
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
        wordLock = new ReentrantLock();
    }

    public void run() {
        int count = 0;
        wordLock.lock();
        try {
            Scanner in = new Scanner(new FileInputStream(filename));

            while (in.hasNext()) {
                in.next();
                count++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found!");
        }
        finally {
    		wordLock.unlock();
    	}
      
        if(threadCount == 0)
        	System.out.println("words counted!");
        
        combinedWordCount += count; 
        System.out.println(filename + ": " + count);
    }

	/**
	 * @return the threadCount
	 */
	public static int getThreadCount() {
		return threadCount;
	}

	/**
	 * @param threadCount the threadCount to set
	 */
	public static void setThreadCount(int threadCount) {
		WordCountRunnable.threadCount = threadCount;
	}
}