package racingcar.utils.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameException;

class TryNumberValidatorTest {

    @Test
    @DisplayName("정상적인 시도 횟수를 입력한 경우")
    void correctInput() {
        String tryNumber = "5";
        assertDoesNotThrow(() -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닌 경우")
    void tryNumberIsNotInput() {
        String tryNumber = "a";
        assertThrows(RacingGameException.NotNumericException.class,
                () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));
    }

    @Test
    @DisplayName("시도 횟수가 양수가 아닌 경우")
    void tryNumberIsNotPositiveNumber() {
        String tryNumber1 = "-1";
        assertThrows(RacingGameException.NotPositiveNumberException.class,
                () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber1));

        String tryNumber2 = "0";
        assertThrows(RacingGameException.NotPositiveNumberException.class,
                () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber2));
    }

    @Test
    @DisplayName("시도 횟수가 입력되지 않았을 경우")
    void tryNumberEmpty() {
        String tryNumber = "";
        assertThrows(RacingGameException.TryNumberEmptyInputException.class,
                () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));
    }
}