package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;

public class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 자동차_이름_입력되지_않은_경우(String carNames) {
        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    public void 자동차이름이_null일_경우_예외발생() {
        // given
        String carNames = null;

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_CAR_NAMES.getMessage());
    }

    @Test
    public void 자동차_2대_미만일_경우() {
        // given
        String carNames = "pobi";

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INSUFFICIENT_CARS.getMessage());
    }

    @Test
    public void 자동차이름이_5자_초과일_경우() {
        // given
        String carNames = "pobi,jimmy0524";

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.TOO_LONG_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10000"})
    public void 시도할횟수가_유효하지_않은_경우(String count) {
        // when & then
        assertThatThrownBy(() -> validator.validateAttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ATTEMPT_COUNT.getMessage());
    }

    @Test
    public void 시도할횟수가_문자인_경우_예외발생() {
        // given
        String count = "abc";

        // when & then
        assertThatThrownBy(() -> validator.validateAttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ATTEMPT_COUNT.getMessage());
    }
}
