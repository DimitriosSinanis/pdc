package pdc_1_4;

public class pdc_1_4 {
	public static void main(String[] args) {

	    int numThreads = 10;

	    /* create and start thread 0 */

	    System.out.println("Starting thread 0");
	    Thread thread = new Thread(new Inner(0, numThreads));
	    thread.start();        

	    /* wait for thread 0 */

	    try {
	        thread.join();
	    } catch (InterruptedException e) {}

	    System.out.println("Threads all done");
	}
	/* inner class containing code for each thread to execute */

	private static class Inner extends Thread {

	    private int myID;
	    private int limit;

	    public Inner(int myID, int limit) {
	        this.myID = myID;
	        this.limit = limit;
	    }

	    public void run() {
	        System.out.println("Hello World from " + myID);

	        /* do recursion until limit is reached */
	        if (myID == limit) {
	              System.out.println("Good Bye World from " + myID);
	        } else {
	              System.out.println("Starting thread " + (myID+1));
	              Thread thread = new Thread(new Inner((myID+1), limit));
	              thread.start();
	              try {
	                  thread.join();
	              } catch (InterruptedException e) {System.out.println("Well... That didn't go as planned!");}
	              
	        }
	    }
	}
}
