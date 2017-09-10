
public class LifeguardZoneRotationGenerator {

	private ZoneManager zoneM;

	public static void main(String[] args) {
		LifeguardZoneRotationGenerator main = new LifeguardZoneRotationGenerator();
		main.setup();
	}

	private void setup() {
		zoneM = new ZoneManager(this);
		zoneM.loadZones();
	}

	public ZoneManager getZoneManager() {
		return this.zoneM;
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
