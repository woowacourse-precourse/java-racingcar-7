package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.enums.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfTurnValidatorTest {
    private NumberOfTurnValidator validator;

    @BeforeEach
    void setUp() {
        validator = new NumberOfTurnValidator();
    }

    @DisplayName("빈 문자열 입력 시 예외 발생 테스트")
    @Test
    void validateNotBlankThrowsExceptionWhenInputIsBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateNumberOfTurn(""),
                "빈 문자열에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_INPUT_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("공백 입력 시 예외 발생 테스트")
    @Test
    void validateNotBlankThrowsExceptionWhenInputIsOnlySpaces() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateNumberOfTurn("   "),
                "공백 문자열에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_INPUT_BLANK.getMessage(), exception.getMessage());
    }

    @DisplayName("양의 정수가 아닌 숫자 입력 시 예외 발생 테스트")
    @Test
    void validateNumericThrowsExceptionForNonPositiveNumbers() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateNumberOfTurn("0"),
                "0에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_TURN_NUMERIC.getMessage(), exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateNumberOfTurn("-5"),
                "음수에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_TURN_NUMERIC.getMessage(), exception.getMessage());
    }

    @DisplayName("숫자가 아닌 입력 시 예외 발생 테스트")
    @Test
    void validateNumericThrowsExceptionForNonNumericInput() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> validator.validateNumberOfTurn("abc"),
                "알파벳 입력에 대한 예외가 발생하지 않았습니다."
        );
        assertEquals(Exceptions.INVALID_TURN_NUMERIC.getMessage(), exception.getMessage());
    }

    @DisplayName("유효한 양의 정수 입력 시 예외 없음 테스트")
    @Test
    void validateNumberOfTurnDoesNotThrowExceptionForValidInput() {
        assertDoesNotThrow(() -> validator.validateNumberOfTurn("5"));
        assertDoesNotThrow(() -> validator.validateNumberOfTurn("12"));
    }
}
