package introThreads;

public class Threadmain {

	public static void main(String[] args) {
		RunnableThreadExample rThread = new RunnableThreadExample();
		System.out.println("in main");
		Thread t = new Thread(rThread);
			t.start();
			
		while(rThread.count!=5){
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
