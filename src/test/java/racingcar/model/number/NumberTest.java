package racingcar.model.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @DisplayName("전진 테스트")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isForward(int input) {
        Number number = new Number(input);

        boolean result = number.isGreaterThanForwardThreshold();

        assertTrue(result);
    }

    @ParameterizedTest
    @DisplayName("멈춤 테스트")
    @ValueSource(ints = {0, 1, 2, 3})
    void isStop(int input) {
        Number number = new Number(input);

        boolean result = number.isGreaterThanForwardThreshold();

        assertFalse(result);
    }
}
