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

    public static Tuple tuple(double x, double y, double z, double w) {
        return new Tuple(x, y, z, w);
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
        return isEqual(w, VECTOR);
    }

    public Tuple add(Tuple tuple) {
        return new Tuple(tuple.x + x, tuple.y + y, tuple.z + z, tuple.w + w);
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
                ", w=" + w +
                '}';
    }

    private boolean isEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    public Tuple subtract(Tuple tuple) {
        return new Tuple(x - tuple.x, y - tuple.y, z - tuple.z, w - tuple.w);
    }

    public Tuple negate() {
        return new Tuple(-x, -y, -z, -w);
    }

    public Tuple multiply(double value) {
        return new Tuple(x * value, y * value, z * value, w * value);
    }

    public Tuple divide(double value) {
        return new Tuple(x / value, y / value, z / value, w / value);
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Tuple normalize() {
        return this.divide(this.getMagnitude());
    }
}
