package gym_Design_Semaphores;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Semaphore;

public class GymThread implements Runnable {
	private Gym gym;
	private Client client;

	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	
	public void run() {

		for (Exercise e : client.getRoutine()) {

			switch (e.getAt()) {

			case LEGPRESSMACHINE:

				performExcercise(this.gym.getLegpressmachine(), e);

				break;
			case BARBELL:
				performExcercise(this.gym.getBarbell(), e);

				break;
			case HACKSQUATMACHINE:
				performExcercise(this.gym.getHacksquatmachine(), e);

				break;

			case LEGEXTENSIONMACHINE:
				performExcercise(this.gym.getLegextensionmachine(), e);

				break;

			case LEGCURLMACHINE:
				performExcercise(this.gym.getLegcurlmachine(), e);

				break;

			case LATPULLDOWNMACHINE:
				performExcercise(this.gym.getLatpulldownmachine(), e);

				break;

			case PECDECKMACHINE:
				performExcercise(this.gym.getPecdeckmachine(), e);

				break;

			case CABLECROSSOVERMACHINE:
				performExcercise(this.gym.getCablecrossovermachine(), e);

				break;

			default:
				break;
			}

		}

	}
	
	private void performExcercise(Semaphore semaphore, Exercise e) {
		try {
			// acquire lock for apparatus
			semaphore.acquire();
			this.startMessage(e.getAt().name());

			// accuire locks for Weights
			accuireLockMap(e.getWeight());
			// Perform exercise for duration specified
			Thread.currentThread().sleep(e.getDuration());

			// Release locks for Weights
			releaseLockMap(e.getWeight());

			semaphore.release();
			this.endMessage(e.getAt().name());

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}


	private void accuireLockMap(Map<WeightPlateSize, Integer> map) {

		try {
			for (Entry<WeightPlateSize, Integer> w : map.entrySet()) {
				switch (w.getKey()) {
				case SMALL_3KG:
					this.gym.getSmallWt().acquire(w.getValue());
					break;
				case MEDIUM_5KG:
					this.gym.getMediumWt().acquire(w.getValue());

					break;
				case LARGE_10KG:
					this.gym.getLargeWt().acquire(w.getValue());
					break;

				default:
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void releaseLockMap(Map<WeightPlateSize, Integer> map) {

		for (Entry<WeightPlateSize, Integer> w : map.entrySet()) {
			switch (w.getKey()) {
			case SMALL_3KG:
				this.gym.getSmallWt().release(w.getValue());
				break;
			case MEDIUM_5KG:
				this.gym.getMediumWt().release(w.getValue());

				break;
			case LARGE_10KG:
				this.gym.getLargeWt().release(w.getValue());
				break;

			default:
				break;
			}
		}

	}

	private void startMessage(String name) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(sdf.format(Calendar.getInstance().getTime()) + "---");
		sb.append(Thread.currentThread().getName() + "\t -- Workout started-->");
		sb.append(name + "\t"+ this.client.toString());
		
		System.out.println(sb.toString());

	}

	private void endMessage(String name) {

		StringBuffer sb = new StringBuffer();
		
		sb.append(sdf.format(Calendar.getInstance().getTime()) + "---");
		sb.append(Thread.currentThread().getName());
		sb.append("\t -- Workout completed-->" + name);
		
		System.out.println(sb.toString());
		
	}

}
