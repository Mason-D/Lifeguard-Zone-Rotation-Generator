/*
 * The main class for LifeguardZoneRotationGenerator
 * 
 * @author Mason Davis
 * @author Jorge E. Garcia
 */
public class LifeguardZoneRotationGenerator {

	private ZoneManager zoneM;
	private LifeguardManager lifeguardM;

	public static void main(String[] args) {
		LifeguardZoneRotationGenerator main = new LifeguardZoneRotationGenerator();
		main.setup();
	}

	/*
	 * Sets up the various managers
	 */
	private void setup() {
		zoneM = new ZoneManager(this);
		zoneM.loadZones();
		lifeguardM = new LifeguardManager(this);
		lifeguardM.loadLifeguards();
	}

	/*
	 * @return The ZoneManager
	 */
	public ZoneManager getZoneManager() {
		return this.zoneM;
	}

	/*
	 * @return The LifeguardManager
	 */
	public LifeguardManager getLifeguardManager() {
		return this.lifeguardM;
	}

	/*
	 * Checks if a String is an int
	 * 
	 * @param input The String to be checked
	 * 
	 * @return True or False depending on if input is an int
	 */
	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
