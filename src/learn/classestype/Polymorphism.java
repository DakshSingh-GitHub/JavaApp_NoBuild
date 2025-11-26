package learn.classestype;
// Polymorphism - Multiple functions which may or may not do similar tasks but have same name
// Every function must have different signature (different number or type of parameters). Polymorphism can be useful in method overloading

class Civilian {
    public void Info(String name) { IO.println(name); }
    public void Info(int age) { IO.println(age); }
    public void Info(String name, int age) { IO.println(name + " " + age); } 
}

public class Polymorphism {
    public static void main(String[] args) {
        Civilian civ = new Civilian();
        civ.Info("John");
        civ.Info(30);
        civ.Info("Add", 12);
    }
}
