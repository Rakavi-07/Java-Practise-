// --- CrewRank.java ---
public final class CrewRank {
    private final String rankName;
    private final int level;
    private final String[] permissions;

    private CrewRank(String rankName, int level, String[] permissions) {
        this.rankName = rankName;
        this.level = level;
        this.permissions = permissions.clone();
    }

    public static CrewRank createCadet() {
        return new CrewRank("Cadet", 1, new String[]{"BASIC"});
    }
    public static CrewRank createOfficer() {
        return new CrewRank("Officer", 2, new String[]{"BASIC","OPS"});
    }
    public static CrewRank createCommander() {
        return new CrewRank("Commander", 3, new String[]{"OPS","COMMAND"});
    }
    public static CrewRank createCaptain() {
        return new CrewRank("Captain", 4, new String[]{"COMMAND","PILOT"});
    }
    public static CrewRank createAdmiral() {
        return new CrewRank("Admiral", 5, new String[]{"ALL"});
    }

    public String getRankName() { return rankName; }
    public int getLevel() { return level; }
    public String[] getPermissions() { return permissions.clone(); }
}
