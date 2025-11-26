package learn.geometry;

public class Implementation {
    public static void main(String[] args) {
        ArithematicProgression ap = new ArithematicProgression(2);
        ap.insertNumber(4);
        ap.insertNumber(6);
        ap.insertNumber(8);
        ap.insertNumber(10);
        ap.insertNumber(12);
        ap.insertNumber(14);
        ap.insertNumber(16);
        ap.insertNumber(18);
        ap.insertNumber(20);
        ap.insertNumber(22);
        ap.insertNumber(24);
        ap.insertNumber(26);
        ap.insertNumber(28);
        ap.insertNumber(30);

        ap.updateAP(6);
        // ap.insertNumber(8);
        ap.insertNumber(10);
        ap.insertNumber(14);
        IO.println(ap.getCurrentSequence());
        IO.println(ap.getRemovedHeap());
        (ap.getAPCurrentValidityTestResult()).forEach((k,v) -> IO.println(k + " : " + v));
        IO.println(ArithematicProgression.getDocs());
    }
}
