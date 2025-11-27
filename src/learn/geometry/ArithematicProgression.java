package learn.geometry;

import java.util.*;

public class ArithematicProgression {
    private double firstNumber;
    private double secondNumber;
    private double difference;
    private boolean isEmpty;
    private boolean isInitialized;
    private ArrayList<Double> sequence;
    private ArrayList<Integer> lastInsertionSize = new ArrayList<>();
    private ArrayList<ArrayList<Double>> removedHeap = new ArrayList<>();

    ArithematicProgression (double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.difference = this.secondNumber - this.firstNumber;
        this.sequence = new ArrayList<>();
        sequence.add(this.firstNumber);
        sequence.add(this.secondNumber);
        this.isEmpty = false;
        this.isInitialized = true;
    }

    ArithematicProgression (double firstNumber) {
        this.firstNumber = firstNumber;
        this.sequence = new ArrayList<>();
        sequence.add(this.firstNumber);
        this.isEmpty = false;
        this.isInitialized = false;
    }

    ArithematicProgression () {
        this.isEmpty = true;
        this.isInitialized = false;
        this.sequence = new ArrayList<>();
    }

    // renamed from insertNumber to insertTerm
    void insertTerm(double number) {
        if (this.isEmpty == true && this.isInitialized == false) {
            this.firstNumber = number;
            this.sequence.add(number);
            this.isEmpty = false;
            this.isInitialized = false;
        } else if (this.isEmpty == false && this.isInitialized == false) {
            double sec_no = number;
            this.secondNumber = sec_no;
            this.difference = this.secondNumber - this.firstNumber;
            this.sequence.add(sec_no);
            this.isEmpty = false;
            this.isInitialized = true;
        } else {
            double lastnumber = this.sequence.get(this.sequence.size() - 1);
            if (number - lastnumber == this.difference) { this.sequence.add(number); }
            else { IO.println("The number " + number + " doesn't match the AP"); }
        }
    }

    // Inserts terms to the nth term without error because user only has to specify of what lenth the array should be, and other stuff is handled within the code. Inserts till the size of the sequence gets "N"
    void insertTillNthTerm(int n) {
        if ((this.isEmpty == true && this.isInitialized == false) || (this.isEmpty == false && this.isInitialized == false)) {
            IO.println("Can't add on a non-initialized AP");
        } else {
            int sizeOfSequence = this.sequence.size();
            if (lastInsertionSize.size() == 0 || lastInsertionSize.get(lastInsertionSize.size()-1) < n) {
                double difference = this.difference;
                ArrayList<Double> numbersOfInsertion = new ArrayList<>();
                for ( int i = sizeOfSequence; i < n; i++ ) {
                    double nextnumber = this.firstNumber + (i)*difference;
                    numbersOfInsertion.add(nextnumber);
                }
                numbersOfInsertion.forEach(e -> { this.sequence.add(e); });
                lastInsertionSize.add(n);
            } else {
                IO.println("The new insertion range should be greater than last: " + lastInsertionSize.get(lastInsertionSize.size()-1));
            }
        }
    }

    void clearAP() {
        ArrayList<Double> copy = new ArrayList<>();
        this.sequence.forEach(e -> { copy.add(e); });
        this.removedHeap.add(copy);
        this.sequence.clear();
        this.isEmpty = true;
        this.isInitialized = false;
    }

    void resetAP(double n_first_term, double n_second_term) {
        ArrayList<Double> copy = new ArrayList<>();
        this.sequence.forEach( e -> { copy.add(e); });
        this.removedHeap.add(copy);
        this.sequence.clear();
        this.firstNumber = n_first_term;
        this.secondNumber = n_second_term;
        this.difference = this.secondNumber - this.firstNumber;
        this.isEmpty = false;
        this.isInitialized = true;
        this.sequence.add(this.firstNumber);
        this.sequence.add(this.secondNumber);
    }

    void updateAP(double n_second_term) {
        this.secondNumber = n_second_term;
        this.difference = this.secondNumber - this.firstNumber;
        double abs_f_term = this.sequence.get(0);
        ArrayList<Double> copy = new ArrayList<>();
        this.sequence.forEach(e -> { copy.add(e); });
        this.removedHeap.add(copy);
        this.sequence.clear();
        this.sequence.add(abs_f_term);
        this.sequence.add(this.secondNumber);
        this.isEmpty = false;
    }

    // Renamed from addNextNumber to safeInsertNextTerm
    void safeInsertNextTerm() {
        // Returns no error while inserting as it predicts next term, properly and inserts it, without the user having to define the term so prevents error
        if (this.isEmpty) { IO.println("No series has been specified"); }
        else {
            double lastnumber = this.sequence.get(this.sequence.size() - 1);
            double nextnumber = lastnumber + this.difference;
            this.sequence.add(nextnumber);
        }
    }

    // Renamed from predictNextNumber to predictTerm
    void predictTerm() {
        if (this.isEmpty) { IO.println("No series has been specified"); }
        else {
            double lastnumber = this.sequence.get(this.sequence.size() - 1);
            double nextnumber = lastnumber + this.difference;
            IO.println("The next number in the AP is (Not added to AP): " + nextnumber);
        }
    }

    // Added a method predictTerm(int n)
    void predictTerm(int n) {
        if (this.isEmpty) { IO.println("No series has been specified"); }
        else {
            double first_number = this.firstNumber;
            double difference = this.difference;
            double nextnumber = first_number + (n-1)*difference;
            IO.println("The next number in the AP is (Not added to AP): " + nextnumber);
        }
    }

    // Renamed from removeNextNumber to removeLastTerm.
    double removeLastTerm() {
        if (this.isEmpty) { return 0; }
        else {
            double lastnumber = this.sequence.remove(this.sequence.size() - 1);
            return lastnumber;
        }
    }

    // Removes the last N terms given by user
    void removeLastNTerms( int n ) {
        for ( int i = 0; i < n; i++ ) removeLastTerm();
        int last_insertion_size = this.lastInsertionSize.removeLast();
        this.lastInsertionSize.add(last_insertion_size - n);
    }

    double sumOfAP() {
        double sum =  0;
        if (this.isEmpty) { IO.println("Sum can't be initialized on an empty AP"); }
        else {
            double n = this.sequence.size();
            sum = (n/2) * (2*this.firstNumber + (n-1)*this.difference);  
        }
        return sum;
    }

    double projectedSumOfAP(int n) {
        double sum =  0;
        if (this.isEmpty) { IO.println("Sum can't be initialized on an empty AP"); }
        else {
            sum = (n/2) * (2*this.firstNumber + (n-1)*this.difference);  
        }
        return sum;
    }

    // Comment region...unnecessary, or so as I think of it. "double predictTerm(int n)" visually does the same thing
    // double nthTerm(int n) {
    //     double term = 0;
    //     if (this.isEmpty) { IO.println("Can not tell the nth term for empty AP"); }
    //     else { term = this.firstNumber + (n-1)*this.difference; }
    //     return term;
    // }

    static boolean checkIfAP(ArithematicProgression ap) {
        if (ap.isEmpty) { return false; }
        else if (ap.sequence.size() < 2) { return false; }
        else {
            ArrayList<Double> seq = ap.getCurrentSequence();
            ArrayList<Double> checkAp = new ArrayList<>() {{ add(seq.get(0));add(seq.get(1)); }};
            double diff = seq.get(1) - seq.get(0);
            double ct = 2;
            int size = seq.size();
            for ( int i = 0; i < size-2; i++ ) { checkAp.add(seq.get(0) + ct*diff); ct++; }
            for ( int i = 0; i < size; i++ ) { if (seq.get(i).doubleValue() != checkAp.get(i).doubleValue()) { return false; } }
            return true;
        }
    }

    static String getDocs() {
        String docs = """
        Arithematic Progression:
            - Every Instance can initialize with 0 arguments, or two elements, no 1 element only is allowed
            - About the methods, can be self explnatory
            - Any return which is equal to 0 means no return
        """;
        return docs;
    }

    Map<String, Boolean> getAPCurrentValidityTestResult() { 
        Map<String, Boolean> res = new HashMap<>();
        res.put("is_ap_empty", this.isEmpty);
        res.put("is_ap_initialized", this.isInitialized);
        res.put("is_ap_valid", ArithematicProgression.checkIfAP(this));
        return res;
    }

    void clearRemovedHeap() { this.removedHeap.clear(); }
    ArrayList<Double> getCurrentSequence() { return this.sequence; }
    ArrayList<ArrayList<Double>> getRemovedHeap() { return this.removedHeap; }
}
