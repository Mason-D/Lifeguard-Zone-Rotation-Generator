import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class APU here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zones{
    // instance variables - replace the example below with your own
    private ArrayList<Lifeguard> APU;
    private ArrayList<Lifeguard> river;
    private ArrayList<Lifeguard> slides;
    private int APUStands;
    private int riverStands;
    private int slidesStands;
    /*
     * Constructor for objects of class APU.
     */
    public Zones(ArrayList<Lifeguard> allLifeguards, int APUNumStands, int riverNumStands, int slidesNumStands,
    int APUBreaks, int riverBreaks, int slidesBreaks) {
        APU = new ArrayList<>();
        river = new ArrayList<>();
        slides = new ArrayList<>();
        APUStands = APUNumStands;
        riverStands = riverNumStands;
        slidesStands = slidesNumStands;
        createZones(allLifeguards, APUNumStands, riverNumStands, slidesNumStands);
        createBreaks(allLifeguards, APUBreaks, riverBreaks, slidesBreaks);
    }

    private void createZones(ArrayList<Lifeguard> allLifeguards, int APUNumStands, int riverNumStands, int slidesNumStands ) {
        int total = APUNumStands + riverNumStands + slidesNumStands;
        Random rand = new Random();
        while (total != 0) {
            int currLifeguard = rand.nextInt(allLifeguards.size());
            boolean addGuard = true;
            double zoneChance = rand.nextDouble();
            if (!allLifeguards.get(currLifeguard).is15()) {
                if (addGuard && zoneChance < .33) {
                    if (APU.size() < APUNumStands) {
                        APU.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                } 
                if (addGuard && zoneChance >= .33 && zoneChance < .66) {
                    if (river.size() < riverNumStands) {
                        river.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                }
                if (addGuard && zoneChance >= .66) {
                    if (slides.size() < slidesNumStands) {
                        slides.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                } 
            } else {
                if (addGuard && zoneChance < .50) {
                    if (APU.size() < APUNumStands) {
                        APU.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                } 
                if (addGuard && zoneChance >= .50) {
                    if (river.size() < riverNumStands) {
                        river.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                }
            }
        }
    }

    private void createBreaks(ArrayList<Lifeguard> allLifeguards, int APUBreaks, int riverBreaks, 
    int slidesBreaks) {
        ArrayList<Lifeguard> APUBreak = new ArrayList<>();
        ArrayList<Lifeguard> riverBreak = new ArrayList<>();
        ArrayList<Lifeguard> slidesBreak = new ArrayList<>();
        int total = APUBreaks + riverBreaks + slidesBreaks;
        Random rand = new Random();
        while (total != 0) {
            int currLifeguard = rand.nextInt(allLifeguards.size()); // potential bug
            boolean addGuard = true;
            double zoneChance = rand.nextDouble();
            if (!allLifeguards.get(currLifeguard).is15()) {
                if (addGuard && zoneChance < .33) {
                    if (APUBreak.size() < APUBreaks) {
                        APUBreak.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                } 
                if (addGuard && zoneChance >= .33 && zoneChance < .66) {
                    if (riverBreak.size() < riverBreaks) {
                        riverBreak.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                }
                if (addGuard && zoneChance >= .66) {
                    if (slidesBreak.size() < slidesBreaks) {
                        slidesBreak.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                } 
            } else {
                if (addGuard && zoneChance < .50) {
                    if (APUBreak.size() < APUBreaks) {
                        APUBreak.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                } 
                if (addGuard && zoneChance >= .50) {
                    if (riverBreak.size() < riverBreaks) {
                        riverBreak.add(allLifeguards.get(currLifeguard));
                        allLifeguards.remove(currLifeguard);
                        addGuard = false;
                        total--;
                    } 
                }
            }
        }
        //addBreakGuards(APUBreak, riverBreak, slidesBreak);
        APU.addAll(APUBreak);
        river.addAll(riverBreak);
        slides.addAll(slidesBreak);
    }

    
    // private void addBreakGuards(ArrayList<Lifeguard> APUBreak, ArrayList<Lifeguard> riverBreak,
    // ArrayList<Lifeguard> slidesBreak) {
    // addBreakGuardsHelper(APU, APUBreak);

    // addBreakGuardsHelper(river, riverBreak);
    // addBreakGuardsHelper(slides, slidesBreak);
    // }

    // private void addBreakGuardsHelper(ArrayList<Lifeguard> zone, ArrayList<Lifeguard> breakGuards) {
    // for (int i = 0; i < breakGuards
    // }

    public void printZonesAndBreaks() {
        System.out.println();
        System.out.println("APU: ");
        printZonesAndBreaksHelper(APU, APUStands);
        System.out.println();
        System.out.println("River: ");
        printZonesAndBreaksHelper(river, riverStands);
        System.out.println();
        System.out.println("Slides: "); 
        printZonesAndBreaksHelper(slides, slidesStands);
        System.out.println();
    }

    private void printZonesAndBreaksHelper(ArrayList<Lifeguard> zone, int stands) {
        for (int i = 0; i < stands; i++) {
            System.out.println((i + 1) + "." + zone.get(i).name());
        }
        System.out.println("Break:");
        for (int i = stands; i < zone.size(); i++) {
            System.out.println(zone.get(i).name());
        }
    }
}