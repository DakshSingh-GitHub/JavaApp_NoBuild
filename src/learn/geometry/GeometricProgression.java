package learn.geometry;

import java.util.ArrayList;

class GeometricProgression {
    private double first_term, second_term;
    private double common_ratio;
    private boolean isEmpty;
    private boolean isInitialized;
    private ArrayList<Double> sequence;
    private ArrayList<ArrayList<Double>> removedHeap = new ArrayList<>();

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

    void clearRemovedHeap() { this.removedHeap.clear(); }
    ArrayList<ArrayList<Double>> getRemovedHeap() { return this.removedHeap; }
    ArrayList<Double> getCurrentSequence() { return this.sequence; }
}