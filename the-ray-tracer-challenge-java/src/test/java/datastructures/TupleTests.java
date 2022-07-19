package datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TupleTests {

    @Nested
    @DisplayName("A tuple exhibits behaviors like a value.")
    class AsAValue {
        @Test
        @DisplayName("A tuple with w=1.0 is a point.")
        void aTupleThatIsAPoint() {
            final Tuple tuple = Tuple.point(4.3, -4.2, 3.1);
            assertEquals(4.3, tuple.getX(), 0.00001);
            assertEquals(-4.2, tuple.getY(), 0.00001);
            assertEquals(3.1, tuple.getZ(), 0.00001);
            assertTrue(tuple.isAPoint());
            assertFalse(tuple.isAVector());
        }

        @Test
        @DisplayName("A tuple with w=0.0 is a vector.")
        void aTupleThatIsAVector() {
            final Tuple tuple = Tuple.vector(4.3, -4.2, 3.1);
            assertEquals(4.3, tuple.getX(), 0.00001);
            assertEquals(-4.2, tuple.getY(), 0.00001);
            assertEquals(3.1, tuple.getZ(), 0.00001);
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

        @Test
        @DisplayName("Adding two points results in an invalid tuple.")
        void twoPoints() {
            Tuple resultant = Tuple.point(4.3, -4.2, 3.1).add(Tuple.point(1.0, 1.0, 0.1));
            assertFalse(resultant.isValid(), "Adding two points is expected to result in an invalid tuple.");
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

        @Test
        @DisplayName("Subtracting a point from a vector results in an invalid tuple.")
        void invalid() {
            Tuple resultant = Tuple.vector(4.3, -4.2, 3.1).subtract(Tuple.point(1.0, 1.0, 0.1));
            assertFalse(resultant.isValid());
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
}
