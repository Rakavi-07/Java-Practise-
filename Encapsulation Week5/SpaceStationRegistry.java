// --- SpaceStationRegistry.java ---
import java.util.*;

public final class SpaceStationRegistry {
    private static final Map<String, Object> crewRegistry = new HashMap<>();

    public static boolean registerCrew(Object crew) {
        if (crew == null) return false;
        crewRegistry.put(UUID.randomUUID().toString(), crew);
        return true;
    }

    public static List<Object> getCrewByType(String type) {
        List<Object> result = new ArrayList<>();
        for (Object obj : crewRegistry.values()) {
            if (obj.getClass().getSimpleName().equalsIgnoreCase(type)) {
                result.add(obj);
            }
        }
        return result;
    }
}
