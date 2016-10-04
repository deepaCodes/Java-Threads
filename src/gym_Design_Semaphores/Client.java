package gym_Design_Semaphores;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private int id;
	private List<Exercise> routine;
	private static int max_exer = 10;

	public Client(int id) {
		this.id = id;
		routine = new ArrayList<Exercise>();
	}

	public int getId() {
		return id;
	}

	public List<Exercise> getRoutine() {
		return routine;
	}

	public void addExercise(Exercise e) {
		this.routine.add(e);
	}

	public static Client generateRandom(int id) {
		Client c = new Client(id);
		// Generate random number of exercises

		double r = Math.random() * max_exer + 1;
		for (int i = 0; i < (int) r; i++) {

			c.addExercise(Exercise.generateRandom());
		}
		return c;
	}
	@Override
	public String toString() {
		StringBuffer sb =  new StringBuffer();
		sb.append("id: "+this.id);
		for (Exercise e : routine) {
			sb.append(e.toString()+",  ");
		}
		return sb.toString();
	}
}
