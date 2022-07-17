package datastructures;

public class Tuple {
    public static final double POINT = 1.0;
    public static final double VECTOR = 0.0;
    private static final double DELTA = 0.00001;
    private final double x;
    private final double y;
    private final double z;
    private final double w;

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public boolean isAPoint() {
        return Math.abs(this.w - 1.0) < DELTA;
    }

    public boolean isAVector() {
        return !this.isAPoint();
    }
}
