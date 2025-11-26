package learn.main;

class Pen {
    String ink_color;
    String type;
    String brand;
    String refill_no;
    String refill_manufacturer;

    Pen(String ink_color, String type, String brand, String refill_no, String refill_manufacturer) {
        // Default constructor
        this.ink_color = ink_color;
        this.type = type;
        this.brand = brand;
        this.refill_no = refill_no;
        this.refill_manufacturer = refill_manufacturer;
    }

    Pen(Pen pen_other) {
        // Copy constructor
        this.ink_color = pen_other.ink_color;
        this.type = pen_other.type;
        this.brand = pen_other.brand;
        this.refill_no = pen_other.refill_no;
        this.refill_manufacturer = pen_other.refill_manufacturer;
    }

    public void write() {
        IO.println("Writing with " + brand + " pen.");
    }

    public void refill() {
        IO.println("Refilling the pen with " + refill_manufacturer + " refill no " + refill_no);
    }
}

public class App {
    public static void main(String[] args) {
        Pen paperkraft_bethoven = new Pen("Blue", "Ballpoint", "Paperkraft", "888M", "Schmidt"); 
        // new - creates a memory slot for the object
        // Pen() - calls the constructor to initialize the object
        // Constructors - special methods which are used to 'construct' a object (same name as class name)
        // If no constructor is defined, Java provides a default constructor

        paperkraft_bethoven.write();
        paperkraft_bethoven.refill();

        Pen parker_neo = new Pen(paperkraft_bethoven);
        parker_neo.brand = "Parker Neo";
        parker_neo.write();
        
    }
}


// Access Modifiers - keywords which set the access level for classes, variables, methods and constructors
// 1. Public - accessible from any other class
// 2. Private - accessible only within the defined class
// 3. Default (no modifier) - accessible only within the same package
// 4. Protected - accessible within the same package and subclasses

// Static keyword - used for memory management mainly. Properties common to all object instances are declared as static. It can be used with variables, methods, blocks and nested classes.

// Polymorphism - Multiple functions which may or may not do similar tasks but have same name
// Every function must have different signature (different number or type of parameters). Polymorphism can be useful in method overloading

// Inheritance increases the reusability of code, the class which has properties is the "parent" class and the class which inherits those properties is the "child" class.
// Types of Inheritance: Single Inheritance, Multilevel Inheritance, Hierarchical Inheritance, Multiple Inheritance (not supported in Java using classes).

// Encapsulation is the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates.

// Abstraction - Hiding internal details and showing only essential features of the object.
// In Java, encapsulation is achieved using access modifiers to set access levels for classes, variables, methods, and constructors.
// Abstract keyword is used to make an abstract class which can not be initiated by itself but can be inherited by other 'child' classes. Abstract classes are more like "ideas" only.
// Abstract method are method which do not have a body but provides a template for child classes to implement.
// If a class doesn't have the implementation of all abstract methods of the parent abstract class, then that class also needs to be declared as abstract.
