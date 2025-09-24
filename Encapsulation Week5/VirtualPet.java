// --- VirtualPet.java ---
import java.util.Objects;
import java.util.UUID;

public class VirtualPet {
    // Immutable core
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    // Mutable state
    private String petName;
    private int age, happiness, health;

    // Constants
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Baby", "Adult"};
    static final int MAX_HAPPINESS = 100, MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    // Constructors (chained)
    public VirtualPet() {
        this("Defaulty", new PetSpecies("Slime", DEFAULT_EVOLUTION_STAGES, 50, "Swamp"), 0, 50, 50);
    }

    public VirtualPet(String petName) {
        this(petName, new PetSpecies("Slime", DEFAULT_EVOLUTION_STAGES, 50, "Swamp"), 0, 50, 50);
    }

    public VirtualPet(String petName, PetSpecies species) {
        this(petName, species, 0, 50, 50);
    }

    public VirtualPet(String petName, PetSpecies species, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.species = Objects.requireNonNull(species);
        this.birthTimestamp = System.currentTimeMillis();
        setPetName(petName);
        setAge(age);
        setHappiness(happiness);
        setHealth(health);
    }

    // JavaBean Getters/Setters
    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = validateStat(age); }
    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { this.happiness = validateStat(happiness); }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = validateStat(health); }

    // Public interface
    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHealth(bonus);
    }

    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
    }

    // Protected calculations
    protected int calculateFoodBonus(String foodType) {
        return switch (foodType.toLowerCase()) {
            case "meat" -> 10;
            case "fruit" -> 5;
            default -> 2;
        };
    }

    protected int calculateGameEffect(String gameType) {
        return gameType.equalsIgnoreCase("fetch") ? 15 : 5;
    }

    // Private helpers
    private void modifyHappiness(int delta) {
        setHappiness(Math.min(MAX_HAPPINESS, happiness + delta));
        updateEvolutionStage();
    }

    private void modifyHealth(int delta) {
        setHealth(Math.min(MAX_HEALTH, health + delta));
    }

    private void updateEvolutionStage() {
        // logic to evolve pet if happiness + age thresholds met
    }

    private int validateStat(int value) {
        return Math.max(0, Math.min(100, value));
    }

    private String generatePetId() {
        return UUID.randomUUID().toString();
    }

    // Package-private
    String getInternalState() {
        return "PetID=" + petId + ", Age=" + age + ", HP=" + health + ", Happy=" + happiness;
    }

    // Object overrides
    @Override
    public String toString() {
        return "VirtualPet{" + petName + ", species=" + species.getSpeciesName() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VirtualPet)) return false;
        VirtualPet that = (VirtualPet) o;
        return petId.equals(that.petId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId);
    }
}

