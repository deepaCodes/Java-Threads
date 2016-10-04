package introThreads;

public class MyClass extends Thread{
	private String name;
	private MyObject mObj;
	
	public MyClass(String n,MyObject obj){
		name= n;
		mObj = obj;
	}
	
	public void run(){
		mObj.foo(name);
	}

}
