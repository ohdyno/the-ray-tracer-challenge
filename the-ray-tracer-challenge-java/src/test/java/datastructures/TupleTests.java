package datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TupleTests {

    public static final double DELTA = 0.00001;

    @Nested
    @DisplayName("A tuple exhibits behaviors like a value.")
    class AsAValue {
        @Test
        @DisplayName("A tuple with w=1.0 is a point.")
        void aTupleThatIsAPoint() {
            final Tuple tuple = Tuple.point(4.3, -4.2, 3.1);
            assertEquals(4.3, tuple.getX(), DELTA);
            assertEquals(-4.2, tuple.getY(), DELTA);
            assertEquals(3.1, tuple.getZ(), DELTA);
            assertTrue(tuple.isAPoint());
            assertFalse(tuple.isAVector());
        }

        @Test
        @DisplayName("A tuple with w=0.0 is a vector.")
        void aTupleThatIsAVector() {
            final Tuple tuple = Tuple.vector(4.3, -4.2, 3.1);
            assertEquals(4.3, tuple.getX(), DELTA);
            assertEquals(-4.2, tuple.getY(), DELTA);
            assertEquals(3.1, tuple.getZ(), DELTA);
            assertTrue(tuple.isAVector());
            assertFalse(tuple.isAPoint());
        }

        @Test
        @DisplayName("Two tuples are equal if they are the same type and their coordinates are the same")
        void equality() {
            assertNotEquals(Tuple.vector(4.3, -4.2, 3.1), Tuple.point(4.3, -4.2, 3.1));
            assertEquals(Tuple.vector(4.3, -4.2, 3.1), Tuple.vector(4.3, -4.2, 3.1));
        }
    }

    @Nested
    @DisplayName("Adding tuples.")
    class Addition {
        @Test
        @DisplayName("Adding two vectors results in a vector with updated components.")
        void twoVectors() {
            Tuple resultant = Tuple.vector(4.3, -4.2, 3.1).add(Tuple.vector(1.0, 1.0, 0.1));
            assertEquals(resultant, Tuple.vector(5.3, -3.2, 3.2));
        }

        @Test
        @DisplayName("Adding a vector and a point results in a point with updated components.")
        void oneVectorAndOnePoint() {
            assertEquals(Tuple.vector(4.3, -4.2, 3.1).add(Tuple.point(1.0, 1.0, 0.1)), Tuple.point(5.3, -3.2, 3.2));
            assertEquals(Tuple.point(4.3, -4.2, 3.1).add(Tuple.vector(1.0, 1.0, 0.1)), Tuple.point(5.3, -3.2, 3.2));
        }
    }

    @Nested
    @DisplayName("Subtracting tuples.")
    class Subtraction {
        @Test
        @DisplayName("Subtracting two points results in the displacement vector.")
        void twoPoints() {
            Tuple resultant = Tuple.point(4.3, -4.2, 3.1).subtract(Tuple.point(1.0, 1.0, 0.1));
            assertEquals(resultant, Tuple.vector(3.3, -5.2, 3.0));
        }

        @Test
        @DisplayName("Subtracting a vector from a point results in a point with updated components.")
        void onePointAndOneVector() {
            Tuple resultant = Tuple.point(4.3, -4.2, 3.1).subtract(Tuple.vector(1.0, 1.0, 0.1));
            assertEquals(resultant, Tuple.point(3.3, -5.2, 3.0));
        }

        @Test
        @DisplayName("Subtracting a vector from another vector results in a vector with updated components.")
        void twoVectors() {
            Tuple resultant = Tuple.vector(4.3, -4.2, 3.1).subtract(Tuple.vector(1.0, 1.0, 0.1));
            assertEquals(resultant, Tuple.vector(3.3, -5.2, 3.0));
        }
    }

    @Nested
    @DisplayName("Negating tuples.")
    class Negation {
        @Test
        @DisplayName("Negating a tuple negates the individual components.")
        void negatingATuple() {
            assertEquals(Tuple.tuple(-4.3, 4.2, -3.1, 1.0), Tuple.tuple(4.3, -4.2, 3.1, -1.0).negate());
        }
    }

    @Nested
    @DisplayName("Scalar Multiplication and Division.")
    class ScalarOperations {
        @Test
        @DisplayName("Multiplying a scalar updates the individual components.")
        void multiplication() {
            assertEquals(Tuple.tuple(3.5, -2 * 3.5, 3 * 3.5, -4 * 3.5), Tuple.tuple(1, -2, 3, -4).multiply(3.5));
        }

        @Test
        @DisplayName("Dividing a scalar updates the individual components.")
        void division() {
            assertEquals(Tuple.tuple(1, -2, 3, -4), Tuple.tuple(3.5, -2 * 3.5, 3 * 3.5, -4 * 3.5).divide(3.5));
        }
    }

    @Nested
    @DisplayName("Magnitude Calculations.")
    class MagnitudeCalculations {
        @Test
        @DisplayName("Computing the magnitude of vector(1, 0, 0)")
        void multiplication() {
            assertEquals(1.0, Tuple.vector(1, 0, 0).getMagnitude(), DELTA);
            assertEquals(1.0, Tuple.vector(0, 1, 0).getMagnitude(), DELTA);
            assertEquals(1.0, Tuple.vector(0, 0, 1).getMagnitude(), DELTA);
            assertEquals(Math.sqrt(14), Tuple.vector(1, 2, 3).getMagnitude(), DELTA);
            assertEquals(Math.sqrt(14), Tuple.vector(-1, -2, -3).getMagnitude(), DELTA);
        }
    }

    @Nested
    @DisplayName("Normalization.")
    class Normalization {
        @Test
        @DisplayName("Normalizing vectors update the components properly.")
        void normalizing() {
            assertEquals(Tuple.vector(1, 0, 0), Tuple.vector(4, 0, 0).normalize());
            final double magnitude = Math.sqrt(14);
            assertEquals(Tuple.vector(1 / magnitude, 2 / magnitude, 3 / magnitude), Tuple.vector(1, 2, 3).normalize());
        }

        @Test
        @DisplayName("A normalized vector is always an unit vector.")
        void alwaysAnUnitVector() {
            final Tuple notAUnitVector = Tuple.vector(1, 2, 3);
            assertTrue(notAUnitVector.getMagnitude() > 1.0);

            final Tuple normalizedVector = notAUnitVector.normalize();
            assertEquals(1.0, normalizedVector.getMagnitude(), DELTA);
        }
    }


}
