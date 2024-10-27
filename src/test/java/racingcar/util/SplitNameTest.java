package racingcar.util;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SplitNameTest {
    @Test
    void testEmptyCarName() {
        assertThrows(IllegalArgumentException.class, () -> SplitName.splitCarName("  "));
    }
    @Test
    void testLastCommaCarName() {
        assertThrows(IllegalArgumentException.class, () -> SplitName.splitCarName("soo,"));
    }
    @Test
    void testSplitCarName() {
        List<String> expected = Arrays.asList("soo", "pobi");
        assertEquals(expected, SplitName.splitCarName("soo, pobi "));
    }
}