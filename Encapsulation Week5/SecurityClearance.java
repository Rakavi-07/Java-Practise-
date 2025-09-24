// --- SecurityClearance.java ---
import java.util.Arrays;
import java.util.UUID;

public final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;

    public SecurityClearance(String level, String[] sections, long expirationDate) {
        if (level == null || level.isBlank()) throw new IllegalArgumentException("Invalid level");
        if (sections == null || sections.length == 0) throw new IllegalArgumentException("No sections authorized");
        if (expirationDate <= System.currentTimeMillis()) throw new IllegalArgumentException("Already expired");

        this.clearanceId = UUID.randomUUID().toString();
        this.level = level;
        this.authorizedSections = sections.clone();
        this.expirationDate = expirationDate;
    }

    public final boolean canAccess(String section) {
        return Arrays.asList(authorizedSections).contains(section);
    }

    public final boolean isExpired() {
        return System.currentTimeMillis() > expirationDate;
    }

    public final int getAccessHash() {
        return (clearanceId + level).hashCode();
    }

    public String getLevel() { return level; }
    public String[] getAuthorizedSections() { return authorizedSections.clone(); }
    public long getExpirationDate() { return expirationDate; }
    public String getClearanceId() { return clearanceId; }
}
