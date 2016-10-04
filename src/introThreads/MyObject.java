package introThreads;

public class MyObject {
	
	public void foo(String name){
		System.out.println("Thread"+ name +".foo(): Starting");
		try {
			Thread.sleep(3000);
			System.out.println("Thread"+ name +".foo(): ending");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
