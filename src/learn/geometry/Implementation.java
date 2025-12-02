package learn.geometry;

public class Implementation {
    public static void main(String[] args) {
        GeometricProgression gp = new GeometricProgression(2, 4);
       
        // IO.println(gp.getCurrentSequence().size());
        // IO.println(gp.getCurrentSequence());
        // gp.insertTillNthTerm(10);
        IO.println(gp.getCurrentSequence());
        // ArrayList<Double> news = gp.getCurrentSequence();
        gp.getGPCurrentValidityTestResult().forEach((k,v) -> IO.println(k + " : " + v));


        // ArithematicProgression ap = new ArithematicProgression(2, 4);
        // // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
        // ap.insertTillNthTerm(10);
        // IO.println(ap.getCurrentSequence());
        // // IO.println(ap.getCurrentSequence().size());
        // ap.insertTillNthTerm(5);
        // IO.println(ap.getCurrentSequence());
        // ap.removeLastNTerms(3);
        // IO.println(ap.getCurrentSequence());
        // ArrayList<Integer> news = new ArrayList<Integer>() {{ add(3);add(4);add(7); }};
        // IO.println(ArithematicProgression.checkIfAPInteger(news));
    }
}
