package datastructures;

public class Tuple {
    private final double x;
    private final double y;
    private final double z;

    public Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
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
        return true;
    }

    public boolean isAVector() {
        return false;
    }
}
