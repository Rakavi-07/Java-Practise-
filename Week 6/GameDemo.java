// Parent class
class Game {
    String name;
    int players;

    Game(String name, int players) {
        this.name = name;
        this.players = players;
    }

    // Override toString()
    @Override
    public String toString() {
        return "Game{name='" + name + "', players=" + players + "}";
    }

    // Override equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same object
        if (obj == null || getClass() != obj.getClass()) return false;

        Game game = (Game) obj;
        return players == game.players && name.equals(game.name);
    }

    // Always override hashCode() when equals() is overridden
    @Override
    public int hashCode() {
        return name.hashCode() + players;
    }
}

// Child class
class CardGame extends Game {
    String deckType;

    CardGame(String name, int players, String deckType) {
        super(name, players);
        this.deckType = deckType;
    }

    // Override toString()
    @Override
    public String toString() {
        return super.toString() + ", CardGame{deckType='" + deckType + "'}";
    }

    // Override equals()
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // check parent fields first
        if (getClass() != obj.getClass()) return false;

        CardGame cg = (CardGame) obj;
        return deckType.equals(cg.deckType);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + deckType.hashCode();
    }
}

// Main class
public class GameDemo {
    public static void main(String[] args) {
        Game g1 = new Game("Chess", 2);
        Game g2 = new Game("Chess", 2);
        CardGame cg1 = new CardGame("Poker", 4, "Standard 52");
        CardGame cg2 = new CardGame("Poker", 4, "Standard 52");
        CardGame cg3 = new CardGame("Poker", 4, "Custom Deck");

        System.out.println("Objects toString():");
        System.out.println(g1);
        System.out.println(cg1);

        System.out.println("\nEquality checks:");
        System.out.println("g1 equals g2? " + g1.equals(g2)); // true
        System.out.println("cg1 equals cg2? " + cg1.equals(cg2)); // true
        System.out.println("cg1 equals cg3? " + cg1.equals(cg3)); // false
    }
}
