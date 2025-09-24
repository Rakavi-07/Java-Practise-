// --- DragonPet.java ---
public class DragonPet {
    private final String dragonType;
    private final String breathWeapon;
    private final VirtualPet basePet;

    public DragonPet(String name, String dragonType, String breathWeapon) {
        this.basePet = new VirtualPet(name, new PetSpecies("Dragon", VirtualPet.DEFAULT_EVOLUTION_STAGES, 200, "Sky"));
        this.dragonType = dragonType;
        this.breathWeapon = breathWeapon;
    }

    public String getDragonType() { return dragonType; }
    public String getBreathWeapon() { return breathWeapon; }
    public VirtualPet getBasePet() { return basePet; }
}

