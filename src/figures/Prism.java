package figures;

public class Prism extends Geometric_Shapes {
    private double length;
    private double width;
    private double height;

    public Prism(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.setVolume(calculateVolume());
        this.setSurfaceArea(calculateSurfaceArea());
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public double calculateSurfaceArea() {
        return 2.0 * (length * width + length * height + width * height);
    }
}
