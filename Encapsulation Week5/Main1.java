// --- Main.java ---
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Create crew
        SpaceCrew crew1 = new SpaceCrew("Earth", CrewRank.createOfficer());
        System.out.println("Crew ID: " + crew1.getCrewIdentification());
        System.out.println("Can be promoted? " + crew1.canBePromoted());

        // Specialized crew
        CommandCrew commander = new CommandCrew(Set.of("Battle Tactics", "Diplomacy"));
        PilotCrew pilot = new PilotCrew(Set.of("Shuttle", "Starfighter"));

        // Registry
        SpaceStationRegistry.registerCrew(crew1);
        SpaceStationRegistry.registerCrew(commander);
        SpaceStationRegistry.registerCrew(pilot);

        System.out.println("Command Crew Registered: " + SpaceStationRegistry.getCrewByType("CommandCrew").size());
        System.out.println("Pilot Crew Registered: " + SpaceStationRegistry.getCrewByType("PilotCrew").size());
    }
}
