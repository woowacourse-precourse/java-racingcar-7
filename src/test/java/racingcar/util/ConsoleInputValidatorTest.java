package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConsoleInputValidatorTest {

    @Test
    @DisplayName("유효한 자동차 이름 입력에 대해 예외가 발생하지 않음")
    void validateCarNames_ValidInput_Success() {
        // given
        String validCarNames = "car1, car2";

        // when
        assertThatCode(() -> ConsoleInputValidator.validateCarNames(validCarNames))
                // then
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("빈 자동차 이름 입력에 대해 예외 발생")
    void validateCarNames_EmptyInput_ThrowsException() {
        // given
        String invalidCarNames = "";

        // when
        assertThatThrownBy(() -> ConsoleInputValidator.validateCarNames(invalidCarNames))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력해야 합니다.");
    }

    @Test
    @DisplayName("자동차가 1대만 입력된 경우 예외 발생")
    void validateCarNames_SingleCarInput_ThrowsException() {
        // given
        String invalidCarNames = "car1";

        // when
        assertThatThrownBy(() -> ConsoleInputValidator.validateCarNames(invalidCarNames))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 2대 이상이어야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있는 경우 예외 발생")
    void validateCarNames_DuplicateNames_ThrowsException() {
        // given
        String invalidCarNames = "car1, car1";

        // when
        assertThatThrownBy(() -> ConsoleInputValidator.validateCarNames(invalidCarNames))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외 발생")
    void validateCarNames_ExceedingLength_ThrowsException() {
        // given
        String carNames = "Car1, Car2, CarLongName";

        // when
        assertThatExceptionOfType(IllegalArgumentException.class)
                // then
                .isThrownBy(() -> ConsoleInputValidator.validateCarNames(carNames))
                .withMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("유효한 시도 횟수에 대해 예외가 발생하지 않음")
    void validateAttemptCount_ValidInput_Success() {
        // given
        int validAttempt = 3;

        // when
        assertThatCode(() -> ConsoleInputValidator.validateAttemptCount(validAttempt))
                // then
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("0 이하의 시도 횟수에 대해 예외 발생")
    void validateAttemptCount_InvalidInput_ThrowsException() {
        // given
        int invalidAttempt = 0;

        // when
        assertThatThrownBy(() -> ConsoleInputValidator.validateAttemptCount(invalidAttempt))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
    }
}
