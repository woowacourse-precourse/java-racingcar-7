package racingcar.validationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingExceptionStatus;
import racingcar.validation.CarNameValidation;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameValidationTest {

    @Test
    @DisplayName("올바른 차 이름 입력")
    void 시도_횟수_입력_성공(){
        String names = "  asd  ";
        assertDoesNotThrow(() -> CarNameValidation.validate(names));
    }

    @Test
    @DisplayName("자동차 이름이 5자를 넘는 경우")
    void validate_carNameTooLong() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidation.validate("LongName");
        });
        assertEquals(RacingExceptionStatus.INVALID_NAME_LENGTH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열인 경우")
    void validate_carNameBlank() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidation.validate("");
        });
        assertEquals(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 공백만 포함된 경우")
    void validate_carNameWithOnlySpace() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidation.validate(" ");
        });
        assertEquals(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage(), exception.getMessage());
    }
}
