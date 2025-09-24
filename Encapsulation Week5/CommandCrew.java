// --- Specialized Crew ---
import java.util.Set;

public class CommandCrew {
    private final Set<String> commandCertifications;
    public CommandCrew(Set<String> certs) { this.commandCertifications = Set.copyOf(certs); }
    public Set<String> getCommandCertifications() { return commandCertifications; }
}

public class PilotCrew {
    private final Set<String> flightCertifications;
    public PilotCrew(Set<String> certs) { this.flightCertifications = Set.copyOf(certs); }
    public Set<String> getFlightCertifications() { return flightCertifications; }
}

public class ScienceCrew {
    private final String researchSpecialty;
    public ScienceCrew(String specialty) { this.researchSpecialty = specialty; }
    public String getResearchSpecialty() { return researchSpecialty; }
}

public class EngineerCrew {
    private final String engineeringType;
    public EngineerCrew(String type) { this.engineeringType = type; }
    public String getEngineeringType() { return engineeringType; }
}
