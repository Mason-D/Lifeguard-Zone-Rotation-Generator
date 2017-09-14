import java.util.ArrayList;
import java.util.List;

/*
 * This class is used to store an Instance of a Zone
 * 
 * @author Mason Davis
 * @author Jorge E. Garcia
 */
public class Zone {
	private String name;
	private int numberOfStands;
	private List<Lifeguard> lifeguards;
	private int ageRequirement;

	/*
	 * Constuctor for class Zone
	 * 
	 * @param name The name of the Zone
	 * 
	 * @param numberOfStands The number of stands in the Zone
	 */
	public Zone(String name, int numberOfStands, int ageRequirement) {
		this.name = name;
		this.numberOfStands = numberOfStands;
		this.ageRequirement = ageRequirement;
		this.lifeguards = new ArrayList<Lifeguard>();
	}

	/*
	 * @return The name of the zone
	 */
	public String getName() {
		return this.name; 
	}

	/*
	 * @return The number of stands in the Zone
	 */
	public int getNumberOfStands() {
		return this.numberOfStands;
	}

	/*
	 * @return A list of all the Lifegaurds assigned to the Zone
	 */
	public List<Lifeguard> getLifeguards() {
		return this.lifeguards;
	}

	public int getAgeRequirement() {
		return this.ageRequirement;
	}

	/*
	 * Assigns a Lifeguard to the Zone
	 * 
	 * @param lifeguard The lifeguard to assign to the zone
	 */
	public void addLifeguard(Lifeguard lifeguard) {
		if (lifeguard == null) {
			throw new IllegalArgumentException("Lifeguard cannot be null");
		}
		this.lifeguards.add(lifeguard);
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
