package figures;

public class Cylinder extends Geometric_Shapes {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
        this.setVolume(calculateVolume());
        this.setSurfaceArea(calculateSurfaceArea());
    }

    public double calculateVolume() {
        return Math.PI * height * Math.pow(radius, 2.0);
    }

    public double calculateSurfaceArea() {
        double sideAreaA = 2.0 * Math.PI * radius * height;
        double sideAreaB = 2.0 * Math.PI * Math.pow(radius, 2.0);
        return sideAreaA + sideAreaB;
    }
}
    