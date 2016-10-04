import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AssignmentOne {
	

	public static void main(String[] args) {

		String[] targs = args ; //{ "1", "101", "201", "301", "401", "501" };
		List<Integer[]> intervals = new ArrayList<Integer[]>();

		for (int i = 0; i < targs.length - 1; i++) {
			Integer[] temp = { Integer.parseInt(targs[i]),
					Integer.parseInt(targs[i + 1]) };
			intervals.add(temp);
		}

		AssignmentOne obj = new AssignmentOne();
		try {
			List<Integer> res = obj.lprimes(intervals);
			Collections.sort(res);
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Integer i : res) {
				sb.append(i + ",");
			}
			sb.append("]");
			
			System.out.println("-------------------final output ---------------------");
			System.out.println(sb.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Integer> lprimes(List<Integer[]> intervals)
			throws InterruptedException {
		Map<Thread, PrimeFinder> threadMap = new HashMap<Thread, PrimeFinder>();

		for (Integer[] i : intervals) {
			System.out.println("[" + i[0] + "," + i[1] + "]");
			PrimeFinder p = new PrimeFinder(i[0], i[1]);
			Thread t = new Thread(p);
			t.start();
			threadMap.put(t, p);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (Entry<Thread, PrimeFinder> e : threadMap.entrySet()) {
			e.getKey().join();
			result.addAll(e.getValue().getPrimesList());
		}

		return result;
	}
	

}
