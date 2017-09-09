import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
 * This class is used to store information for a lifeguard and is used 
 * by the ZoneRotations class.
 */



public class Lifeguard {
    // instance variables - replace the example below with your own
	public static final String LIFEGUARD_FILE = "lifeguard_names.txt";
    private String name;
    private boolean is15;

    /*
     * Constructor for objects of class Lifeguard.
     */
    public Lifeguard(String name) {
        this.name = capName(name);
        this.is15 = checkIf15(name);
    }
    
    private String capName(String name) {
        String n = "" + name.charAt(0);
        n = n.toUpperCase() + name.substring(1);
        return n;
    }

    // Improvement: have a file with all the names
    private boolean checkIf15(String name) {
    	name = name.toLowerCase();
    	Scanner fileScanner = getFileScannerForNames(LIFEGUARD_FILE);
        fileScanner.nextLine();
    	fileScanner.nextLine();
    	while (fileScanner.hasNextLine()) {
    		String lastName = fileScanner.next().toLowerCase();
    		lastName = lastName.substring(0, lastName.length() - 1);
    		String firstName = fileScanner.next().toLowerCase();
    		String firstAndLast = firstName + " " + lastName;
    		String firstAndInitial = firstName + " " + lastName.charAt(0);
    		String firstAndInitial2 = firstName + " ." + lastName.charAt(0); // has period before initial
    		if (name.equals(firstAndLast) || name.equals(firstAndInitial) || name.equals(firstAndInitial2)) {
    			System.out.println("got one!");
    			return true;
    		}
    	}
    	fileScanner.close();
        return false;
    }
    
    private static Scanner getFileScannerForNames(String fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Returning null for Scanner"
					+ "object. Problems likely to occur." + e);
		}
		return sc;
	}
    
    /*
     * Returns the name of this lifeguard.
     */
    public String name() {
        return name;
    }
    
    
    
    /*
     * Returns true if this lifeguard is 15 years of age.
     */
    public boolean is15() {
       return is15;
    }
    
    public String toString() {
        return name;
    }
}
