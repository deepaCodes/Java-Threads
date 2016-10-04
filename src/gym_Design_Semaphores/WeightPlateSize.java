package gym_Design_Semaphores;

public enum WeightPlateSize {
	 SMALL_3KG, MEDIUM_5KG, LARGE_10KG;
	 
	 public static int randomWeight(int numPlates){
			double n = Math.random()*numPlates +1;
			return (int)n;
		}

}
