package figures;

public class Cube extends Geometric_Shapes {
    private double side;

    public Cube(double side) {
        this.side = side;
        this.setVolume(calculateVolume());
        this.setSurfaceArea(calculateSurfaceArea());
    }

    public double calculateVolume() {
        return Math.pow(side, 3.0);
    }

    public double calculateSurfaceArea() {
        return 6.0 * Math.pow(side, 2.0);
    }
}
