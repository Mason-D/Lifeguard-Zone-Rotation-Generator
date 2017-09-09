import java.util.Scanner;
import java.util.ArrayList;
/*
 * Write a description of class ZoneRotations here.
 *
 * Author: Jorge E. Gacia
 * Version: 1.0
 * Last Update: July 20, 2017
 */
public class ZoneRotations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        instructions();
        ArrayList<Lifeguard> lifeguards = addLifeguards(sc);
        Zones strawberryZones = assignZones(lifeguards, sc);
        strawberryZones.printZonesAndBreaks();
        sc.close();
    }

    public static void instructions() {
        System.out.println("Welcome to Jorge E. Garcia's Zone Rotations program.");
        System.out.println();
        System.out.println("Current Version: 1.0");
        System.out.println("Update Changes:");
        System.out.println("- Program checks for correct input.");
        System.out.println("- Program contains full list of 15 year old guards");
        System.out.println("- Capatalization feature added to lifguard name");
        System.out.println("- And other minor bug fixes");
        System.out.println();
        System.out.println("Instructions:");
        System.out.println("You will need: ");
        System.out.println("- The total amount of guards working for the shift.");
        System.out.println("- The names of every guard for the shift.");
        System.out.println("- The number of stands and breaks for each zone.");
        System.out.println("After that, you will just have to follow the prompts.");
        System.out.println();
   
    }

    public static ArrayList<Lifeguard> addLifeguards(Scanner sc) {
        int totalGuards = getTotalGuards(sc);
        ArrayList<Lifeguard> lifeguards = new ArrayList<>();
        while (totalGuards != 0) {
            System.out.print("Enter the lifeguard's full name or first name and last initial: ");
            String name = sc.nextLine();
            Lifeguard newLifeguard = new Lifeguard(name);
            lifeguards.add(newLifeguard);
            System.out.println();
            totalGuards--;
        }
        return lifeguards;
    }

    private static int getTotalGuards(Scanner sc) {
        System.out.print("Enter the number of guards: ");
        String totalGuards = sc.nextLine();
        System.out.println();
        while (!isPositiveInteger(totalGuards)) {
            System.out.println("Inccorect input. Input must be a positive integer ");
            System.out.print("Enter the number of guards: ");
            totalGuards = sc.nextLine();
            System.out.println();
        }
        return Integer.parseInt(totalGuards);
    }

    public static boolean isPositiveInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static Zones assignZones(ArrayList<Lifeguard> lifeguards, Scanner sc) {
    	int totalLG = lifeguards.size();
        System.out.print("Enter the number of stands for the APU: ");
        int APUStands = sc.nextInt();
        totalLG -= APUStands;
        sc.nextLine();
        
        System.out.println();
        System.out.println("There is " + totalLG + " lifeguards left." );
        System.out.println();
        System.out.print("Enter the number of stands for the river: ");
        int riverStands = sc.nextInt();
        totalLG -= riverStands;
        sc.nextLine();
        
        System.out.println();
        System.out.println("There is " + totalLG + " lifeguards left." );
        System.out.println();
        System.out.print("Enter the number of stands for the slides: ");
        int slidesStands = sc.nextInt();
        totalLG -= slidesStands;
        sc.nextLine();
        
        System.out.println();
        System.out.println("There is " + totalLG + " lifeguards left." );
        System.out.println();
        System.out.print("Enter the number of breaks for the APU: ");
        int APUBreaks = sc.nextInt();
        totalLG -= APUBreaks;
        sc.nextLine();
        
        System.out.println();
        System.out.println("There is " + totalLG + " lifeguards left." );
        System.out.println();
        System.out.print("Enter the number of breaks for the river: ");
        int riverBreaks = sc.nextInt();
        totalLG -= riverBreaks;
        sc.nextLine();
        
        System.out.println();
        System.out.println("There is " + totalLG + " lifeguards left." );
        System.out.println();
        System.out.print("Enter the number of breaks for the slides: ");
        int slidesBreaks = sc.nextInt();
        sc.nextLine();
        return new Zones(lifeguards, APUStands, riverStands, slidesStands, APUBreaks, riverBreaks, slidesBreaks);
    }

}
