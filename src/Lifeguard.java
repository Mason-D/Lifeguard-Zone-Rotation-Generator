/*
 * This class is used to create an instance of a Lifeguard for use else where
 * 
 * @author Mason Davis 
 * @author Jorge E. Garcia
 */
public class Lifeguard {
	private String name;
	private int age;

	/*
	 * Constructor for class Lifeguard
	 * 
	 * @param name The name of the Lifeguard
	 * 
	 * @param age The age of the Lifeguard
	 */
	public Lifeguard(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/*
	 * @return The name of the Lifeguard
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * @return The age of the Lifeguard
	 */
	public int getAge() {
		return this.age;
	}
}
