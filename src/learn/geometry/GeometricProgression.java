package learn.geometry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GeometricProgression {
    private double first_term, second_term;
    private double common_ratio;
    private boolean isEmpty;
    private boolean isInitialized;
    private ArrayList<Double> sequence;
    private ArrayList<ArrayList<Double>> removedHeap = new ArrayList<>();
    private ArrayList<Integer> lastInsertionSize = new ArrayList<>();

    GeometricProgression() {
        this.isEmpty = true;
        this.isInitialized = false;
        this.sequence = new ArrayList<Double>();
    }

    GeometricProgression(double first_term) {
        this.first_term = first_term;
        this.isEmpty = false;
        this.isInitialized = false;
        this.sequence = new ArrayList<Double>();
        this.sequence.add(this.first_term);
    }

    GeometricProgression(double first_term, double second_term) {
        this.first_term = first_term;
        this.second_term = second_term;
        this.common_ratio = this.second_term / this.first_term;
        this.isEmpty = false;
        this.isInitialized = true;
        this.sequence = new ArrayList<Double>();
        this.sequence.add(this.first_term);
        this.sequence.add(this.second_term);
    }

    void insertTerm(double n) {
        if (this.isEmpty==true && this.isInitialized==false) {
            this.first_term = n;
            this.sequence.add(n);
            this.isEmpty = false;
            this.isInitialized = false;
        } else if (this.isEmpty==false && !this.isInitialized==true) { 
            this.second_term = n;
            this.common_ratio = this.second_term / this.first_term;
            this.sequence.add(n);
            this.isInitialized = true;
        } else if (this.isEmpty==false && this.isInitialized==true) {
            if (this.sequence.get(this.sequence.size()-1)*this.common_ratio == n) {
                this.sequence.add(n);
            } else { IO.println("The number " + n + " doesn't belong to the series"); }
        }
    }

    void insertTillNthTerm(int n) {
        if ((this.isEmpty == true && this.isInitialized == false) || (this.isEmpty == false && this.isInitialized == false)) {
            IO.println("Can't add on a non-initialized AP");
        } else {
            int sizeOfSequence = this.sequence.size();
            if (lastInsertionSize.size() == 0 || lastInsertionSize.get(lastInsertionSize.size()-1) < n) {
                double common_ratio = this.common_ratio;
                ArrayList<Double> numbersOfInsertion = new ArrayList<>();
                for ( int i = sizeOfSequence; i < n; i++ ) {
                    double nextnumber = this.first_term*(Math.pow(common_ratio, i));
                    numbersOfInsertion.add(nextnumber);
                }
                numbersOfInsertion.forEach(e -> { this.sequence.add(e); });
                lastInsertionSize.add(n);
            } else {
                IO.println("The new insertion range should be greater than last: " + lastInsertionSize.get(lastInsertionSize.size()-1));
            }
        }
    }

    // This is a safe insert function, it doesn't show any error because the next insertion term is automated
    void safeInsertNextTerm() {
        if (this.isEmpty == true && this.isInitialized == false) IO.println("Can't addd on a non-initialized GP");
        else {
            double currentLastTerm = this.sequence.get(this.sequence.size()-1);
            double nextTerm = currentLastTerm * this.common_ratio;
            this.sequence.add(nextTerm);
        }
    }

    // Suggest better ways
    void clearGP() {
        ArrayList<Double> copy = new ArrayList<Double>();
        this.sequence.forEach(e -> { copy.add(e); });
        this.removedHeap.add(copy);
        this.sequence.clear();
        this.isEmpty = true;
        this.isInitialized = false;
    }

    void updateGP(double n_second_term) {
        this.second_term = n_second_term;
        this.common_ratio = this.second_term / this.first_term;
        double abs_f_term = this.sequence.get(0);
        ArrayList<Double> copy = new ArrayList<Double>();
        this.sequence.forEach(e -> { copy.add(e); });
        this.removedHeap.add(copy);
        this.sequence.clear();
        this.sequence.add(abs_f_term);
        this.sequence.add(this.second_term);
    }

    void resetGP(double n_first_term, double n_second_term) {
        this.first_term = n_first_term;
        this.second_term = n_second_term;
        this.common_ratio = this.second_term / this.first_term;
        ArrayList<Double> copy = new ArrayList<Double>();
        this.sequence.forEach(e -> { copy.add(e); });
        this.removedHeap.add(copy);
        this.sequence.clear();
        this.sequence.add(this.first_term);
        this.sequence.add(this.second_term);
        this.isEmpty = false;
        this.isInitialized = true;
    }

    double predictTerm() {
        double nextTerm = this.sequence.get(this.sequence.size()-1) * this.common_ratio;
        return nextTerm;
    }

    double predictTerm( int n ) {
        double nextTerm = this.first_term * Math.pow(this.common_ratio, n-1);
        return nextTerm;
    }

    double sumOfGP() {
        double sum = 0.0;
        if (this.isEmpty == true) { IO.println("Sum can't be initialized on an empty GP"); }
        else {
            double n = this.sequence.size();
            double a = this.sequence.get(0);
            double r = this.common_ratio;
            if (r < 1) sum = a*(1-Math.pow(r, n))/(1-r);
            else sum = a*(Math.pow(r, n)-1)/(r-1);
        }
        return sum;
    }

    // Returns sum of the geometric progression till any specified number/place
    double projectedSumOfGP(int n) {
        double sum = 0.0;
        if (this.isEmpty == true) { IO.println("Sum can't be initialized on an empty GP"); }
        else {
            double a = this.sequence.get(0);
            double r = this.common_ratio;
            if (r < 1) sum = a*(1-Math.pow(r, n))/(1-r);
            else sum = a*(Math.pow(r, n)-1)/(r-1);
        }
        return sum;
    }

    static boolean isValidGP(ArrayList<Double> sequence) {
        if (sequence.size() == 0 || sequence.size() == 1 || sequence.size() == 2) { return false; }
        else {
            // ArrayList<Double> seq = sequence;
            int size = sequence.size();
            double f_term = sequence.get(0);
            double s_term = sequence.get(1);
            double common_ratio = s_term / f_term;
            ArrayList<Double> checkGP = new ArrayList<>() {{ add(f_term);add(s_term); }};
            double ct = 2;
            for ( int i = 0; i < size - 2; i++ ) { checkGP.add(f_term * Math.pow(common_ratio, ct)); ct++; }
            for ( int i = 0; i < size; i++ ) { if (sequence.get(i).doubleValue() != checkGP.get(i).doubleValue()) {return false;} }
        }
        return true;
    }

    Map<String, Boolean> getGPCurrentValidityTestResult() { 
        Map<String, Boolean> res = new HashMap<>();
        res.put("is_gp_empty", this.isEmpty);
        res.put("is_gp_initialized", this.isInitialized);
        res.put("is_gp_valid", GeometricProgression.isValidGP(this.sequence));
        return res;
    }

    void clearRemovedHeap() { this.removedHeap.clear(); }
    ArrayList<ArrayList<Double>> getRemovedHeap() { return this.removedHeap; }
    ArrayList<Double> getCurrentSequence() { return this.sequence; }
}
