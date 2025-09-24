// Abstract parent class
abstract class Food {
    // Template method (final so subclasses can't change the sequence)
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    // Steps (can be overridden by subclasses)
    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

// Child class Pizza
class Pizza extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables and preparing dough for pizza.");
    }

    @Override
    protected void cook() {
        System.out.println("Baking pizza in the oven.");
    }

    @Override
    protected void serve() {
        System.out.println("Serving hot pizza with extra cheese.");
    }
}

// Child class Soup
class Soup extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables for soup.");
    }

    @Override
    protected void cook() {
        System.out.println("Boiling vegetables and adding spices for soup.");
    }

    @Override
    protected void serve() {
        System.out.println("Serving soup in a bowl with a spoon.");
    }
}

// Main class
public class FoodDemo {
    public static void main(String[] args) {
        System.out.println("Preparing Pizza:");
        Food pizza = new Pizza();
        pizza.prepare();

        System.out.println("\nPreparing Soup:");
        Food soup = new Soup();
        soup.prepare();
    }
}
