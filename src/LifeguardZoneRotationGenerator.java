
public class LifeguardZoneRotationGenerator {

	private ZoneManager zoneM;

	public static void main(String[] args) {
		LifeguardZoneRotationGenerator main = new LifeguardZoneRotationGenerator();
		main.setup();
	}

	private void setup() {
		zoneM = new ZoneManager(this);
	}

	public ZoneManager getZoneManager() {
		return this.zoneM;
	}
}
