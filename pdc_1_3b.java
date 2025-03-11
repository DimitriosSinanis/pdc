package pdc_1_3b;

public class pdc_1_3b {
	public static void main(String[] args) {

        /* allocate array of thread object */
        int numThreads = 7 ;
       
        /* create and start threads */
        new Thread() {
        	public void run() {
        		for (int i = 0; i < numThreads/2; i++) {
                    	   System.out.println("Hello from thread " + i + " out of " + numThreads);
        		      }  
                    }
                 }.start();
                 
       new Thread() {
            public void run() {
                for (int i = numThreads/2; i < numThreads; i++) {
                          System.out.println("Thread " + i + " exits");
                 		}  
                       }
                     }.start();
          
      }
	}

