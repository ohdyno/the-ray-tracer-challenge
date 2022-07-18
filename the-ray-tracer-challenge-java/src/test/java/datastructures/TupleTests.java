package datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TupleTests {

    @Nested
    @DisplayName("A tuple exhibits behaviors like a value.")
    class ValueBehaviorTests {
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
    class AdditionBehaviorTests {
        @Test
        @DisplayName("Adding two vectors results in a vector with updated components.")
        void twoVectors() {
            Tuple resultant = Tuple.vector(4.3, -4.2, 3.1).add(Tuple.vector(1.0, 1.0, 0.1));
            assertEquals(resultant, Tuple.vector(5.3, -3.2, 3.2));
        }

        @Test
        @DisplayName("Adding a vector and a point results in a point with updated components.")
        void oneVectorAndOnePoint() {
            Tuple resultant = Tuple.vector(4.3, -4.2, 3.1).add(Tuple.point(1.0, 1.0, 0.1));
            assertEquals(resultant, Tuple.point(5.3, -3.2, 3.2));
        }

        @Test
        @DisplayName("Adding two points results in an invalid tuple.")
        void twoPoints() {
            Tuple resultant = Tuple.point(4.3, -4.2, 3.1).add(Tuple.point(1.0, 1.0, 0.1));
            assertFalse(resultant.isValid(), "Adding two points is expected to result in an invalid tuple.");
        }
    }
}
