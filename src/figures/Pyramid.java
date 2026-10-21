package figures;

public class Pyramid extends Geometric_Shapes {
    private double base;
    private double height;
    private double apothem;

    public Pyramid(double base, double height, double apothem) {
        this.base = base;
        this.height = height;
        this.apothem = apothem;
        this.setVolume(calculateVolume());
        this.setSurfaceArea(calculateSurfaceArea());
    }

    public double calculateVolume() {
        return (Math.pow(base, 2.0) * height) / 3.0;
    }

    public double calculateSurfaceArea() {
        double baseArea = Math.pow(base, 2.0);
        double sideArea = 2.0 * base * apothem;
        return baseArea + sideArea;
    }
}
