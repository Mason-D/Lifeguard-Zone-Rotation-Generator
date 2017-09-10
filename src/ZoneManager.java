import java.util.ArrayList;
import java.util.List;

public class ZoneManager {

	private LifeguardZoneRotationGenerator main;

	private List<Zone> zones;

	public ZoneManager(LifeguardZoneRotationGenerator main) {
		this.main = main;
		this.zones = new ArrayList<Zone>();
	}
}
