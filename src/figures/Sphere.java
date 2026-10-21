package figures;

public class Sphere extends Geometric_Shapes {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
        this.setVolume(calculateVolume());
        this.setSurfaceArea(calculateSurfaceArea());
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3.0);
    }

    public double calculateSurfaceArea() {
        return 4.0 * Math.PI * Math.pow(this.radius, 2.0);
    }
}
