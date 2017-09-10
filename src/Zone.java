import java.util.ArrayList;
import java.util.List;

/*
 * 
 */
public class Zone {
	private String name;
	private int numberOfStands;
	private List<Lifeguard> lifeguards;

	public Zone(String name, int numberOfStands) {
		this.name = name;
		this.numberOfStands = numberOfStands;
		this.lifeguards = new ArrayList<Lifeguard>();
	}

	public String getName() {
		return this.name;
	}

	public int getNumberOfStands() {
		return this.numberOfStands;
	}

	public List<Lifeguard> getLifeguards() {
		return this.lifeguards;
	}

	public void addLifeguard(Lifeguard lifeguard) {
		if (lifeguard == null) {
			throw new IllegalArgumentException("Lifeguard cannot be null");
		}
		this.lifeguards.add(lifeguard);
	}
}
