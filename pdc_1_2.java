package pdc_1_2;

public class pdc_1_2 {

    public static void main(String[] args) {

        /* allocate array of thread objecst */
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];

        /* create and start threads */
        for (int i = 0; i < numThreads; ++i) {
            System.out.println("In main: create and start thread " + i);
            if ( i < numThreads/2)
			    threads[i] = new Thread1(i);
			
			else
				threads[i] = new Thread2(i,numThreads);
			
            threads[i].start();
            
        }
		
			
        /* wait for threads to finish */
        for (int i = 0; i < numThreads; ++i) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                System.err.println("this should not happen");
            }
        }

        System.out.println("In main: threads all done");
    }
}

/* class containing code for each thread to execute */
abstract class MyThread extends Thread {

    /* instance variables */
    protected int myID;
   

    /* constructor */
    public MyThread(int myID) {
        this.myID = myID;
    }
    
	/* thread code */
    abstract public void run();
}

class Thread1 extends MyThread{
	
	/* constructor */
	public Thread1(int myID) {
        super(myID);
    }
	
	/* thread code */
	public void run(){
		System.out.println("Thread " + myID + " exits");	
	}
	
}

class Thread2 extends MyThread{
	
	/* instance variables */
    private int totalThreads;
	
	/* constructor */
	public Thread2(int myID, int totalThreads) {
        super(myID);
		this.totalThreads = totalThreads;
    }
	
	/* thread code */
	public void run(){
		System.out.println("Hello from thread " + myID + " out of " + totalThreads);	
	}
	
}
