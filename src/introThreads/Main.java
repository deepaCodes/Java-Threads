package introThreads;

public class Main {

	public static void main(String[] args) {
		MyObject m1  = new MyObject();
		MyObject m2  = new MyObject();

		MyClass thread1 = new MyClass("1",m1);
		MyClass thread2 = new MyClass("2",m1);

		thread1.start();
		thread2.start();
	}

}
