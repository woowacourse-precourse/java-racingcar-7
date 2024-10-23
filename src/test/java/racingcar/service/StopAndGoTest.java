package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class StopAndGoTest {

    private final StopAndGo stopAndGo = new StopAndGo();

    @Test
    void stopAndGo_ShouldReturnArrayOfCorrectLength() {
        int times = 5;

        boolean[] result = stopAndGo.stopAndGo(times);

        assertEquals(times, result.length);
    }

    @Test
    void stopAndGo_ShouldReturnBooleanArray() {
        int times = 10;

        boolean[] result = stopAndGo.stopAndGo(times);

        for (boolean value : result) {
            assertTrue(value == true || value == false);
        }
    }
}
