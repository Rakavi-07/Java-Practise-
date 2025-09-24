// --- SpaceCrew.java ---
import java.util.Objects;
import java.util.UUID;

public class SpaceCrew {
    private final String crewId;
    private final String homeplanet;
    private final SecurityClearance clearance;
    private final CrewRank initialRank;

    private CrewRank currentRank;
    private int missionCount;
    private double spaceHours;

    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;

    // Emergency recruitment
    public SpaceCrew() {
        this("Unknown", "Mars", CrewRank.createCadet(), new SecurityClearance("Low", new String[]{"COMMON"}, System.currentTimeMillis()+1000000), 0, 0);
    }

    // Standard recruitment
    public SpaceCrew(String homeplanet, CrewRank initialRank) {
        this("Crew-" + UUID.randomUUID(), homeplanet, initialRank, new SecurityClearance("Medium", new String[]{"COMMON","OPS"}, System.currentTimeMillis()+5000000), 0, 0);
    }

    // Experienced transfer
    public SpaceCrew(String homeplanet, CrewRank initialRank, int missionCount, double spaceHours) {
        this("Crew-" + UUID.randomUUID(), homeplanet, initialRank, new SecurityClearance("High", new String[]{"COMMON","OPS","COMMAND"}, System.currentTimeMillis()+10000000), missionCount, spaceHours);
    }

    // Full constructor
    public SpaceCrew(String crewId, String homeplanet, CrewRank initialRank, SecurityClearance clearance, int missionCount, double spaceHours) {
        this.crewId = Objects.requireNonNull(crewId);
        this.homeplanet = Objects.requireNonNull(homeplanet);
        this.initialRank = Objects.requireNonNull(initialRank);
        this.clearance = Objects.requireNonNull(clearance);
        this.currentRank = initialRank;
        this.missionCount = missionCount;
        this.spaceHours = spaceHours;
    }

    // Final methods
    public final String getCrewIdentification() {
        return crewId + "@" + STATION_NAME;
    }

    public final boolean canBePromoted() {
        return currentRank.getLevel() < CrewRank.createAdmiral().getLevel() && missionCount > 5;
    }

    public final int calculateSecurityRating() {
        return currentRank.getLevel() * 100 + missionCount * 10;
    }

    private final boolean validateClearanceLevel() {
        return !clearance.isExpired();
    }

    // Getters/Setters
    public CrewRank getCurrentRank() { return currentRank; }
    public void setCurrentRank(CrewRank currentRank) { this.currentRank = currentRank; }
    public int getMissionCount() { return missionCount; }
    public void setMissionCount(int missionCount) { this.missionCount = Math.max(0, missionCount); }
    public double getSpaceHours() { return spaceHours; }
    public void setSpaceHours(double spaceHours) { this.spaceHours = Math.max(0, spaceHours); }
}
