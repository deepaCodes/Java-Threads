package introThreads;

public class RunnableThreadExample implements Runnable {
	int count=0;
	public void run() {
		System.out.println("inside run");
		while(count<5){
			try {
				Thread.sleep(500);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("runnable ending");
	}
	
}
