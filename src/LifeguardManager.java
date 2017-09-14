import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * This class is used to manage Lifeguards, such as loading them from the text file and creating instances of each
 * 
 * @author Mason Davis
 * @author Jorge E. Garcia
 */
public class LifeguardManager {
	private LifeguardZoneRotationGenerator main;

	private File lifeguardFile;
	private List<Lifeguard> lifeguards;

	/*
	 * Constructor for the LifeguardManager class
	 * 
	 * @param main The main class
	 */
	public LifeguardManager(LifeguardZoneRotationGenerator main) {
		this.main = main;
		this.lifeguards = new ArrayList<Lifeguard>();
		this.lifeguardFile = new File("lifeguards.txt");
	}

	/*
	 * Loads the Lifeguards from the text file and stores them in the list,
	 * lifeguards
	 */
	public void loadLifeguards() {
		Scanner lifeguardsFile;
		try {
			lifeguardFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			lifeguardsFile = new Scanner(new FileReader(lifeguardFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		String[] data;
		String input;
		while (lifeguardsFile.hasNextLine()) {
			input = lifeguardsFile.nextLine();
			data = input.split("\\|");
			if (!LifeguardZoneRotationGenerator.isInt(data[1])) {
				throw new NumberFormatException(
						"The value you inputed for the age of " + data[0] + " is not an acceptable value!");
			}
			this.lifeguards.add(new Lifeguard(data[0], Integer.parseInt(data[1])));
		}
		lifeguardsFile.close();
	}

	public List<Lifeguard> getLifeguard(Predicate<Lifeguard> pred) {
		return this.getLifeguards().stream().filter(pred).collect(Collectors.toList());
	}

	public List<Lifeguard> getLifeguard(int ageRequirement) {
		return this.getLifeguard(lifeguard -> {
			return lifeguard.getAge() >= ageRequirement;
		});
	}

	public List<Lifeguard> getLifeguards() {
		return this.lifeguards;
	}
}
