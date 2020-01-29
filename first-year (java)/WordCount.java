/**
   Counts how many words in a file.
*/
public class WordCount {
    public static void main(String[] args) {
    	
    	String[] files = new String[4];
        // make sure to match file names exactly (including the extension) 
    	files[0] = "BramStoker-Dracula.txt";
    	files[1] = "mary1.txt";
    	files[2] = "shakespeare-hamlet.txt";
    	files[3] = "shakespeare-macbeth.txt";
    	
        // A new thread is created for EACH argument (file) provided
        for (int i = 0; i < files.length; i++) {
            WordCountRunnable wcr = new WordCountRunnable(files[i]);
            Thread t = new Thread(wcr); // create a thread 
            t.start(); // call the start() method on the thread, which will call run()
            wcr.setThreadCount(wcr.getThreadCount() + 1);
        }
        
    }
}