package introThreads;

public class ClaculateSum extends Thread{
	private int start;
	private int end;
	private int sum;
	public int tno;
	
	
	public ClaculateSum(int s,int e,int tn) {
		start=s;
		end=e;
		tno=tn;
	}
	
	public void findSum(){
		for(int i=start;i<=end;i++){
			sum+= i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int getTotalSum(){
		return sum;
		
	}

	public void run(){
		System.out.println("thread "+tno+" started");
		findSum();
		System.out.println("total sum between "+start+" and "+end +" is "+sum);
		System.out.println("thread "+tno+" ends");
	}
}
