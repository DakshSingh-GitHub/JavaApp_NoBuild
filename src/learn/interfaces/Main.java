package learn.interfaces;

interface Animal {
    public static final String veinsFlow = "Blood"; // This is a constant
    // Any variable declared must be public, static and final
    void walk();
    // Animal(); // Interfaces can not have constructors
    // void eat() {}; // Interfaces can not have method implementation or body
}

interface Herbivore extends Animal {
    public static final String grazefields = "grass";
    void graze();
}

@SuppressWarnings("unused")
class Horse implements Animal, Herbivore {
    String biome = "Land"; // Error: cannot assign a value to final variable biome
    public void walk() { IO.println("Walks on a biome" + " : " + biome); }
    public void graze() { IO.println("Grazes on " + grazefields); }
}

public class Main {
    public static void main(String[] args) {
        IO.println("hwe");
    }
}
