package racingcar.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();
    private final InputParser parser = new InputParser();

    @Test
    @DisplayName("입력이 null일 때 예외 발생")
    void 입력이_null일_때() {
        // given
        String nullInput = null;

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateInput(nullInput)
        );

        // then
        assertEquals("빈 값은 허용하지 않습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("빈 문자열일 때 예외 발생")
    void 입력이_빈_문자열일_때() {
        // given
        String emptyInput = " ";

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateInput(emptyInput)
        );

        // then
        assertEquals("빈 값은 허용하지 않습니다.", exception.getMessage());
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

    @Test
    @DisplayName("경주 횟수가 유효하지 않은 숫자일 때 예외 발생")
    void 경주_횟수가_유효하지_않은_형식일_때() {
        // given
        String wrongFormatInput = "a";

        // when
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateCount(parser.parseInt(wrongFormatInput))
        );

        // then
        assertEquals("유효한 숫자를 입력해 주세요.", exception.getMessage());
    }
}
