// --- Main.java ---
public class Main {
    public static void main(String[] args) {
        // Create a PetSpecies (immutable config)
        PetSpecies slimeSpecies = new PetSpecies(
            "Slime",
            new String[]{"Blob", "Mega Blob", "King Slime"},
            80,
            "Swamp"
        );

        // Create a VirtualPet
        VirtualPet pet = new VirtualPet("Slimy", slimeSpecies);
        System.out.println("Created Pet: " + pet);

        // Interact with pet
        pet.feedPet("fruit");
        pet.playWithPet("fetch");

        System.out.println("After playing & feeding: " + pet.getInternalState());

        // Create specialized pets
        DragonPet dragon = new DragonPet("Draco", "Fire Dragon", "Fire Breath");
        RobotPet robot = new RobotPet("RoboBuddy");

        System.out.println("Dragon type: " + dragon.getDragonType() + ", Weapon: " + dragon.getBreathWeapon());
        System.out.println("Robot battery: " + robot.getBatteryLevel() + "%");
    }
}
