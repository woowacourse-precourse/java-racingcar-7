package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();
    private final InputParser parser = new InputParser();

    @Test
    @DisplayName("빈 값 또는 null 입력 시 예외 발생")
    void validateInputWithEmptyOrNull() {
        // given
        String nullInput = null;
        String emptyInput = " ";

        // when
        IllegalArgumentException exception1 = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateInput(nullInput)
        );
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateInput(emptyInput)
        );

        // then
        String emptyErrorMessage = "빈 값은 허용하지 않습니다.";
        assertEquals(emptyErrorMessage, exception1.getMessage());
        assertEquals(emptyErrorMessage, exception2.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과 시 예외 발생")
    void 이름이_5자_초과할_때() {
        // given
        String exceedInput = "kim, glenn, minseok"; // minseok은 5자 초과

        // when
        IllegalArgumentException exceedException = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateName(parser.parseCarNames(exceedInput))
        );

        // then
        assertEquals("자동차 이름은 최대 5자까지 가능합니다.", exceedException.getMessage());
    }

    @Test
    @DisplayName("빈 이름 포함 시 예외 발생")
    void 이름에_빈_값_포함할_때() {
        // given
        String emptyInput = "kim, , glenn"; // 빈 이름 포함

        // when
        IllegalArgumentException emptyException = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateName(parser.parseCarNames(emptyInput))
        );

        // then
        assertEquals("자동차 이름은 비어 있을 수 없습니다.", emptyException.getMessage());
    }

    @Test
    @DisplayName("경주 횟수가 0 이하일 때 예외 발생")
    void 경주_횟수가_0일_때() {
        // given
        int zeroRound = 0;

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCount(zeroRound)
        );

        // then
        assertEquals("경주 횟수는 0보다 커야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("경주 횟수가 음수일 때 예외 발생")
    void 경주_횟수가_음수일_때() {
        // given
        int negativeRound = -1;

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCount(negativeRound)
        );

        // then
        assertEquals("경주 횟수는 0보다 커야 합니다.", exception.getMessage());
    }
}
