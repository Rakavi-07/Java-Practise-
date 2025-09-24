// --- RobotPet.java ---
public class RobotPet {
    private boolean needsCharging;
    private int batteryLevel;
    private final VirtualPet basePet;

    public RobotPet(String name) {
        this.basePet = new VirtualPet(name, new PetSpecies("Robot", VirtualPet.DEFAULT_EVOLUTION_STAGES, 999, "Lab"));
        this.needsCharging = false;
        this.batteryLevel = 100;
    }

    public boolean isNeedsCharging() { return needsCharging; }
    public void setNeedsCharging(boolean needsCharging) { this.needsCharging = needsCharging; }
    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) { this.batteryLevel = Math.max(0, Math.min(100, batteryLevel)); }
}

