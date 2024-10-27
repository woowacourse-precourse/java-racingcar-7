package racingcar;

import org.junit.jupiter.api.Test;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameContextTest {
    @Test
    void 전진_조건_만족_테스트() {
        Supplier<Integer> customSupplier = () -> 4;
        GameContext gameConText = new GameContext(null, 0, customSupplier);
        boolean result = gameConText.shouldMove();

        assertTrue(result);
    }

    @Test
    void 전진_조건_불만족_테스트() {
        Supplier<Integer> customSupplier = () -> 3;
        GameContext gameConText = new GameContext(null, 0, customSupplier);
        boolean result = gameConText.shouldMove();

        assertFalse(result);
    }
}
