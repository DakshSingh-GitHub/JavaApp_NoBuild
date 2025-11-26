package learn.classestype;

// Access Modifiers - keywords which set the access level for classes, variables, methods and constructors
// 1. Public - accessible from any other class
// 2. Private - accessible only within the defined class
// 3. Default (no modifier) - accessible only within the same package
// 4. Protected - accessible within the same package and subclasses

class BankAccounts {
    public String bank_name;
    String account_number;
    protected double balance;
    private Boolean ghaplebaazi = true;

    public Boolean getScams() { return ghaplebaazi; } 
    public void setScams(Boolean ghaplebaazic) { ghaplebaazi = ghaplebaazic; }
}

public class AccessModifiers {
    public static void main(String[] args) {
        BankAccounts acc = new BankAccounts();
        acc.bank_name = "State Bank of India"; // public - accessible
        acc.account_number = "SBIN0001234"; // default - accessible within same package
        acc.balance = 5000.0; // private - not accessible outside BankAccounts class
        acc.getScams(); // accessing private variable via public getter method
        acc.setScams(false); // modifying private variable via public setter method
    }
}
