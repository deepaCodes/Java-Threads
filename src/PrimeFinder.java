
import java.util.ArrayList;
import java.util.List;

public class PrimeFinder implements Runnable {
	private Integer start;
	private Integer end;
	private List<Integer> primes;

	PrimeFinder(Integer startNum, Integer endNum) {
		this.start = startNum;
		this.end = endNum;
		this.primes = new ArrayList<Integer>();
	}

	// Returns the value of the attribute primes
	public List<Integer> getPrimesList() {
		return this.primes;
	}

	// Determines whether its argument is prime or not
	public Boolean isPrime(int n) {
		if(n==2) return true;
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public void run() {
		System.out.println("indise primefinder");
		for (int i = this.start; i <= this.end; i++) {
			if(i==1) continue;
			if (isPrime(i)) {
				this.primes.add(i);
			}
		}
		System.out.println("thread complete");
	}

}
