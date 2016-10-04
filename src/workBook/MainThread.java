package workBook;

import java.util.concurrent.Semaphore;

public class MainThread {

	public static void main(String[] args) {
		
		
		final Semaphore printF = new Semaphore(0);
		final Semaphore printC = new Semaphore(0);

		
		
		Thread1 t1= new Thread1(){
			public void run(){
				System.out.println(a);
				printF.release();
				System.out.println(b);
				try {
					printC.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(c);
		
		}
		};
		Thread2 t2 = new Thread2(){
			public void run(){
				System.out.println(e);
				try {
					printF.acquire();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(f);
				printC.release();
				System.out.println(g);

			}

			
		};
		t1.start();
		t2.start();
		
		

	}

}
