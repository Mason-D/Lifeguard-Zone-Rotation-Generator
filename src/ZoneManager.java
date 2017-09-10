import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is used to manage Zones, such as loading them from the 
 * text file and creating the Zones with the information on the file
 */
public class ZoneManager {

	private LifeguardZoneRotationGenerator main;
	private List<Zone> zones;

	/*
	 * Constructor for class ZoneManger
	 * 
	 * @param main The main class
	 */
	public ZoneManager(LifeguardZoneRotationGenerator main) {
		this.main = main;
		this.zones = new ArrayList<Zone>();
	}

	/*
	 * (pending comment)
	 */
	public void loadZones() {
		Scanner zonesFile = new Scanner("zones.txt");
		String[] data;
		String input;
		while (zonesFile.hasNextLine()) {
			input = zonesFile.nextLine();
			data = input.split("\\|");
			if (!LifeguardZoneRotationGenerator.isInt(data[1])) {
				throw new NumberFormatException("The value you inputed for the number of stands for " + data[0]
						+ " is not an acceptable value!");
			}
			this.zones.add(new Zone(data[0], Integer.parseInt(data[1])));
		}
		zonesFile.close();
	}
}