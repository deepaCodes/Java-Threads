package gym_Design_Semaphores;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Exercise {
	private ApparatusType at;
	private Map<WeightPlateSize,Integer> weight;
	private int duration; 
	
	public Exercise(ApparatusType at, Map<WeightPlateSize,Integer> weight, int duration)
	{
		this.at=at;
		this.weight=weight;
		this.duration=duration;
	
	}
	public ApparatusType getAt() {
		return at;
	}
	public Map<WeightPlateSize, Integer> getWeight() {
		return weight;
	}
	public int getDuration() {
		return duration;
	}
	public static Exercise generateRandom(){
		ApparatusType app =ApparatusType.randomApparatus();
		Map<WeightPlateSize,Integer> tempweight= new HashMap<WeightPlateSize, Integer>();
		tempweight.put(WeightPlateSize.SMALL_3KG, WeightPlateSize.randomWeight(Constants.SMALL_PLATES_TOTAL));
		tempweight.put(WeightPlateSize.MEDIUM_5KG, WeightPlateSize.randomWeight(Constants.MEDIUM_PLATES_TOTAL));
		tempweight.put(WeightPlateSize.LARGE_10KG, WeightPlateSize.randomWeight(Constants.LARGE_PLATES_TOTAL));

		Exercise e = new Exercise(app,tempweight, Constants.DURATION_MILLS);

		return e;
		
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("apparatus : " + at);
		sb.append(" Routine [");

		for (Entry<WeightPlateSize,Integer> entry : this.weight.entrySet()) {
			sb.append(entry.getKey() +"->"+entry.getValue()+", ");
		}
		sb.append("]");
		return sb.toString();
	}

}
