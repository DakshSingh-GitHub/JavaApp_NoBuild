package learn.classestype;
// Encapsulation is the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates.
// Abstraction - Hiding internal details and showing only essential features of the object.
// In Java, encapsulation is achieved using access modifiers to set access levels for classes, variables, methods, and constructors.


abstract class Animal {
    String nameOfAnimal;
    String biome = "Open Land";
    abstract public void walk();
    // can have static methods, and concrete methods also...also constructors
    Animal() { IO.println("Animal Constructor"); }
}

// Abstract keyword is used to make an abstract class which can not be initiated by itself but can be inherited by other 'child' classes. Abstract classes are more like "ideas" only.
// Abstract method are method which do not have a body but provides a template for child classes to implement.
// If a class doesn't have the implementation of all abstract methods of the parent abstract class, then that class also needs to be declared as abstract.

class Horse extends Animal {
    String biome = "Grassland";
    public void walk() { IO.println("Walking in biome" + " : " + biome); }
}

class Chicken extends Animal {
    String biome = "Farm Land";
    public void walk() { IO.println("Walking in biome" + " : " + biome); }
}

// Constructor chaining - Under Inheritance,the parent class constructor and the child class constructor both will be called
public class AbstractionEncapsulation {
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.walk();
    }
}
