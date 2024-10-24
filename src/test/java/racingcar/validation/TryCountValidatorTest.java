package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

class TryCountValidatorTest {

    @DisplayName("경주 시도 횟수에 1보다 작은 수를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void validateUnderOne(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TryCountValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.TRY_COUNT_UNDER_ONE.getMessage(), exception.getMessage());
    }

    @DisplayName("경주 시도 횟수를 입력하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TryCountValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_TRY_COUNT_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("경주 시도 횟수에 숫자가 아닌 값을 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"ae", "숫자", "1,2", "-1"})
    void validateNotNumber(String input) {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TryCountValidator.validate(input);
        });

        Assertions.assertEquals(ErrorMessage.NOT_ALLOW_TRY_COUNT_WITHOUT_NUM.getMessage(), exception.getMessage());
    }
}