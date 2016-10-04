package workBook;

import java.util.concurrent.Semaphore;

public class testSemaphore {

	public static void main(String[] args) {
		final Semaphore s= new Semaphore(5);
		System.out.println(s.availablePermits());

		try {
			s.acquire();
			System.out.println(s.availablePermits());
			
			s.acquire();
			System.out.println(s.availablePermits());
			
			s.acquire();
			System.out.println(s.availablePermits());
			
			s.acquire();
			System.out.println(s.availablePermits());
			
			s.acquire();
			System.out.println(s.availablePermits());

			
			s.release();
			System.out.println(s.availablePermits());

			s.acquire();
			System.out.println(s.availablePermits());

			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		System.out.println("done");
	}

}
