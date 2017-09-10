
public class LifeguardZoneRotationGenerator {

	private ZoneManager zoneM;
	private LifeguardManager lifeguardM;

	public static void main(String[] args) {
		LifeguardZoneRotationGenerator main = new LifeguardZoneRotationGenerator();
		main.setup();
	}

	private void setup() {
		zoneM = new ZoneManager(this);
		zoneM.loadZones();
		lifeguardM = new LifeguardManager(this);
		lifeguardM.loadLifeguards();
	}

	public ZoneManager getZoneManager() {
		return this.zoneM;
	}

	public LifeguardManager getLifeguardManager() {
		return this.lifeguardM;
	}

	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
