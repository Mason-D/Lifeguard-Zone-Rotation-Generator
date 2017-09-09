/*
 * This class is used to create an instance of a Lifeguard for use else where
 * 
 * @author Mason Davis & Jorge E. Garcia
 */
public class Lifeguard {
	private String name;
	private boolean overFifteen;

	/*
	 * Constructor for class Lifeguard
	 * 
	 * @param name The name of the Lifeguard
	 * 
	 * @param overFifteen Whether or not the Lifeguard is over the age of fifteen
	 */
	public Lifeguard(String name, boolean overFifteen) {
		this.name = name;
		this.overFifteen = overFifteen;
	}

	/*
	 * @return The name of the Lifeguard
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * @return Whether or not the Lifeguard is over the age of fifteen
	 */
	public boolean isOverFifteen() {
		return this.overFifteen;
	}
}
