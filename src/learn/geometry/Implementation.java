package learn.geometry;

public class Implementation {
    public static void main(String[] args) {
        ArithematicProgression ap = new ArithematicProgression(2, 4);
        // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
        ap.insertTillNthTerm(10);
        IO.println(ap.getCurrentSequence());
        // IO.println(ap.getCurrentSequence().size());
        ap.insertTillNthTerm(15);
        IO.println(ap.getCurrentSequence());
        ap.removeLastNTerms(3);
        IO.println(ap.getCurrentSequence());

    }
}
