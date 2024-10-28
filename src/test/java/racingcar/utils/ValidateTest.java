package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.domain.Round;

public class ValidateTest {
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    @Test
    void throwsExceptionWhenNameExceedsLengthLimit() {
        String carNames = "pobi,woni,junjun";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.registerCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NAME_LENGTH_OVER_LIMIT_MESSAGE);
    }

    @DisplayName("이름을 입력하지 않은 경우 예외 발생")
    @Test
    void throwsExceptionWhenNameIsEmpty() {
        String carNames = "";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.registerCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INPUT_NAME_MESSAGE);
    }

    @DisplayName("이름이 중복하는 경우 예외 발생")
    @Test
    void throwsExceptionWhenNameIsDuplicate() {
        String carNames = "pobi, pobi";
        Cars cars = new Cars();

        assertThatThrownBy(() -> cars.registerCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NAME_ALREADY_EXISTS_MESSAGE);
    }

    @DisplayName("시도할 횟수가 숫자가 아닌 경우 예외 발생")
    @Test
    void throwsExceptionWhenAttemptCountIsNotNumber() {
        String attemptCountInput = "ㅇ";

        assertThatThrownBy(() -> new Round(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.NUMBER_FORMAT_EXCEPTION_MESSAGE);
    }

    @DisplayName("시도할 횟수가 양수가 아닌 경우 예외 발생")
    @Test
    void throwsExceptionWhenAttemptCountIsNotPositiveNumber() {
        String attemptCountInput = "-1";

        assertThatThrownBy(() -> new Round(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.MIN_ATTEMPT_COUNT_MESSAGE);
    }
}
