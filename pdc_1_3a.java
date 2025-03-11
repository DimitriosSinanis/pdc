package pdc_1_3a;

public class pdc_1_3a {

    public static void main(String[] args) {

        /* allocate array of thread object */
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];

        /* create and start threads */
        for (int i = 0; i < numThreads; ++i) {
             System.out.println("In main: create and start thread " + i);
            if ( i < numThreads/2)
			    threads[i] = new Thread(new Thread1(i));
			
			else
				threads[i] = new Thread(new Thread2(i,numThreads));
			
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
    
	
    /* class containing code for each thread to execute */
	private static class Thread1 extends Thread{
	
		/* instance variables */
        protected int myID;
		
		/* constructor */
	    public Thread1(int myID) {
	    	this.myID = myID;
        }
	
	    /* thread code */
	    public void run(){
		   System.out.println("Thread " + myID + " exits");	
	     }
	
    }

	/* class containing code for each thread to execute */
	private static class Thread2 extends Thread{
	
	   /* instance variables */
		protected int myID;
		private int totalThreads;
	
	   /* constructor */
	   public Thread2(int myID, int totalThreads) {
		  this.myID = myID;
		  this.totalThreads = totalThreads;
        } 
	
	   /* thread code */
	   public void run(){
		  System.out.println("Hello from thread " + myID + " out of " + totalThreads);	
	    }
	}
	
}

