package datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TuplesTest {
    @Test
    @DisplayName("A tuple with w=1.0 is a point")
    void aTupleThatIsAPoint() {
        final Tuple tuple = Tuple.point(4.3, -4.2, 3.1);
        assertEquals(4.3, tuple.getX(), 0.00001);
        assertEquals(-4.2, tuple.getY(), 0.00001);
        assertEquals(3.1, tuple.getZ(), 0.00001);
        assertTrue(tuple.isAPoint());
        assertFalse(tuple.isAVector());
    }

    @Test
    @DisplayName("A tuple with w=0.0 is a vector")
    void aTupleThatIsAVector() {
        final Tuple tuple = Tuple.vector(4.3, -4.2, 3.1);
        assertEquals(4.3, tuple.getX(), 0.00001);
        assertEquals(-4.2, tuple.getY(), 0.00001);
        assertEquals(3.1, tuple.getZ(), 0.00001);
        assertTrue(tuple.isAVector());
        assertFalse(tuple.isAPoint());
    }
}
