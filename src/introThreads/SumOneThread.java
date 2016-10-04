package introThreads;

import java.util.ArrayList;
import java.util.List;

public class SumOneThread {

	public static void main(String[] args) {
		int n = 100;
		int sum = 0;
		long start = System.currentTimeMillis();
		/*
		 * for(int i=1;i<=n;i++){ sum+=i; try { Thread.sleep(100); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } cs.findSum();
		 * System.out.println(cs.getTotalSum());
		 */
		// ClaculateSum cs = new ClaculateSum(1,100);
		// cs.start();
		int count = 0;
		int c = 0;

		List<ClaculateSum> tList = new ArrayList<ClaculateSum>();
		for (int i = 1; i <= 100; i = i + 10) {
			ClaculateSum cs = new ClaculateSum(i, i + 9, ++count);
			cs.start();
			tList.add(cs);

		}
		for (ClaculateSum cl : tList) {
			try {
				System.out.println("waiting for thread "+ cl.tno +"  to finish");
				cl.join();
				System.out.println("thread "+ cl.tno +" finished");

				sum += cl.getTotalSum();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		System.out.println("total time in sec="+(System.currentTimeMillis() - start) / 1000);
		System.out.println(sum);
	}

}
