package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 시도_횟수_유효성_검증_테스트() {

        int result = InputView.parseAttempts("5");
        assertEquals(5, result);

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.parseAttempts("five");
        });
    }
}