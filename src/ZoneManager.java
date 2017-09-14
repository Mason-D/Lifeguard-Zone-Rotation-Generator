import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * This class is used to manage Zones, such as loading them from the 
 * text file and creating the Zones with the information on the file
 * 
 * @author Mason Davis 
 * @author Jorge E. Garcia
 */
public class ZoneManager {

	private LifeguardZoneRotationGenerator main;

	private File zoneFile;
	private List<Zone> zones;

	/*
	 * Constructor for class ZoneManger
	 * 
	 * @param main The main class
	 */
	public ZoneManager(LifeguardZoneRotationGenerator main) {
		this.main = main;
		this.zones = new ArrayList<Zone>();
		this.zoneFile = new File("zones.txt");
	}

	/*
	 * Loads the Zones from the text file and stores them in the list, zones
	 */
	public void loadZones() {
		try {
			this.zoneFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner zonesFile;
		try {
			zonesFile = new Scanner(this.zoneFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		String[] data;
		String input;
		while (zonesFile.hasNextLine()) {
			input = zonesFile.nextLine();
			data = input.split("\\|");
			if (!LifeguardZoneRotationGenerator.isInt(data[1]) || !LifeguardZoneRotationGenerator.isInt(data[2])) {
				throw new NumberFormatException("The value you inputed for the number of stands or age requirement for "
						+ data[0] + " is not an acceptable value!");
			}
			this.zones.add(new Zone(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
		}
		zonesFile.close();
	}

	public List<Zone> getZones() {
		return this.zones;
	}
}