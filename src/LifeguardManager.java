import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is used to manage Lifeguards, such as loading them from the text file and creating instances of each
 * 
 * @author Mason Davis
 * @author Jorge E. Garcia
 */
public class LifeguardManager {
	private LifeguardZoneRotationGenerator main;

	private List<Lifeguard> lifeguards;

	/*
	 * Constructor for the LifeguardManager class
	 * 
	 * @param main The main class
	 */
	public LifeguardManager(LifeguardZoneRotationGenerator main) {
		this.main = main;
		this.lifeguards = new ArrayList<Lifeguard>();
	}

	/*
	 * Loads the Lifeguards from the text file and stores them in the list,
	 * lifeguards
	 */
	public void loadLifeguards() {
		Scanner lifeguardsFile = new Scanner("lifeguards.txt");
		String[] data;
		String input;
		while (lifeguardsFile.hasNextLine()) {
			input = lifeguardsFile.nextLine();
			data = input.split("\\|");
			if (!LifeguardZoneRotationGenerator.isInt(data[1]) || !LifeguardZoneRotationGenerator.isInt(data[2])) {
				throw new NumberFormatException(
						"The value you inputed for the age of " + data[0] + " is not an acceptable value!");
			}
			this.lifeguards.add(new Lifeguard(data[0], Integer.parseInt(data[1])));
		}
		lifeguardsFile.close();
	}
}
