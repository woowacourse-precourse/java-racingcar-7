package racingcar.model.number;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    private static final int LESS_THAN_MIN_NUMBER = -1;
    private static final int EXCEED_MAX_NUMBER = 10;

    @ParameterizedTest
    @DisplayName("랜덤 숫자 범위 초과 시, 예외 테스트")
    @ValueSource(ints = {LESS_THAN_MIN_NUMBER, EXCEED_MAX_NUMBER})
    void invalidNumber(int input) {
        assertThrows(IllegalArgumentException.class, () -> new Number(input));
    }

    @ParameterizedTest
    @DisplayName("정상 범위 시, 정상 생성 테스트")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void validNumber(int input) {
        Number number = new Number(input);

        assertNotNull(number);
    }

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
