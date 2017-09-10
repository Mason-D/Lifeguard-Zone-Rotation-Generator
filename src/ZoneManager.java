import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZoneManager {

	private LifeguardZoneRotationGenerator main;

	private List<Zone> zones;

	public ZoneManager(LifeguardZoneRotationGenerator main) {
		this.main = main;
		this.zones = new ArrayList<Zone>();
	}

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