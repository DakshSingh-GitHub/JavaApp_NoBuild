package learn.geometry;

public class Implementation {
    public static void main(String[] args) {
        GeometricProgression gp = new GeometricProgression(2, 4);
        gp.insertTerm(8);
        IO.println(gp.predictTerm(14));
        IO.println(gp.sumOfGP());
    }
}
