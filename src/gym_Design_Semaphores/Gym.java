package gym_Design_Semaphores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Gym {
	private static final int gym_Size=30;
	private static final int gym_REGISTERED_CLIENTS = 10000; 
	private Map<WeightPlateSize,Integer> noOfWeightPlates; //weightplatesize- number of them
	private List<Integer> clients; 
	private ExecutorService executor; 
	
	/* semaphores  */
	private final Semaphore legpressmachine = new Semaphore(5);
	private final Semaphore barbell = new Semaphore(5);
	private final Semaphore hacksquatmachine = new Semaphore(5);
	private final Semaphore legextensionmachine = new Semaphore(5);
	private final Semaphore legcurlmachine = new Semaphore(5);
	private final Semaphore latpulldownmachine = new Semaphore(5);
	private final Semaphore pecdeckmachine = new Semaphore(5);
	private final Semaphore cablecrossovermachine = new Semaphore(5);
	
	private final Semaphore smallWt = new Semaphore(40);
	private final Semaphore mediumWt = new Semaphore(30);
	private final Semaphore largeWt = new Semaphore(20);
	
	/* end of Semaphore */
	
	
	public Gym(){
		noOfWeightPlates = new HashMap<WeightPlateSize, Integer>();
		noOfWeightPlates.put(WeightPlateSize.SMALL_3KG, Constants.SMALL_PLATES_TOTAL);
		noOfWeightPlates.put(WeightPlateSize.MEDIUM_5KG, Constants.MEDIUM_PLATES_TOTAL);
		noOfWeightPlates.put(WeightPlateSize.LARGE_10KG, Constants.LARGE_PLATES_TOTAL);
		
		clients = new ArrayList<Integer>();

		for(int i=1;i<=gym_REGISTERED_CLIENTS;i++){
			clients.add(i);
		}
		executor = Executors.newFixedThreadPool(gym_Size); 
	}
	
	public void execute(){
		for (Integer id : clients) {
			//send the gym obj and client obj to the thread
			GymThread thread = new GymThread();
			thread.setGym(this);
			Client c=Client.generateRandom(id);
			thread.setClient(c);
			
			executor.submit(thread);
		}
		executor.shutdown();
	}

	public Semaphore getLegpressmachine() {
		return legpressmachine;
	}

	public Semaphore getBarbell() {
		return barbell;
	}

	public Semaphore getHacksquatmachine() {
		return hacksquatmachine;
	}

	public Semaphore getLegextensionmachine() {
		return legextensionmachine;
	}

	public Semaphore getLegcurlmachine() {
		return legcurlmachine;
	}

	public Semaphore getLatpulldownmachine() {
		return latpulldownmachine;
	}

	public Semaphore getPecdeckmachine() {
		return pecdeckmachine;
	}

	public Semaphore getCablecrossovermachine() {
		return cablecrossovermachine;
	}

	public Semaphore getSmallWt() {
		return smallWt;
	}

	public Semaphore getMediumWt() {
		return mediumWt;
	}

	public Semaphore getLargeWt() {
		return largeWt;
	}
	
	
	
	

}
