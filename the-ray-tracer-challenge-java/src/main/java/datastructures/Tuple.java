package datastructures;

import java.util.Objects;

public class Tuple {
    public static final double POINT = 1.0;
    public static final double VECTOR = 0.0;
    private static final double EPSILON = 0.00001;
    private final double x;
    private final double y;
    private final double z;
    private final double w;

    private Tuple(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public static Tuple point(double x, double y, double z) {
        return new Tuple(x, y, z, Tuple.POINT);
    }

    public static Tuple vector(double x, double y, double z) {
        return new Tuple(x, y, z, Tuple.VECTOR);
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
        return isEqual(w, POINT);
    }

    public boolean isAVector() {
        return !this.isAPoint();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple other = (Tuple) o;
        return isEqual(other.x, x) && isEqual(other.y, y) && isEqual(other.z, z) && isEqual(other.w, w);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", type=" + (isEqual(w, VECTOR) ? "vector" : "point") +
                '}';
    }

    private boolean isEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

}
