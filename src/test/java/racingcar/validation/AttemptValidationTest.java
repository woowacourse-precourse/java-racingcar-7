package racingcar.validationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingExceptionStatus;
import racingcar.utils.validation.AttemptValidation;

import static org.junit.jupiter.api.Assertions.*;

public class AttemptValidationTest {

    @Test
    @DisplayName("올바른 시도 횟수 입력")
    void 시도_횟수_입력_성공(){
        String attempt = "3";
        assertDoesNotThrow(() -> AttemptValidation.validate(attempt));

    }

    @Test
    @DisplayName("실패 : 시도 횟수 음수 입력")
    void 시도_횟수_입력_실패_음수() {
        // 정상적인 음의 정수 입력 (예외 발생 예상)
        String negativeAttempt = "-10";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            AttemptValidation.validate(negativeAttempt);
        });
        assertEquals(RacingExceptionStatus.INVALID_ATTEMPTS_INTEGER.getMessage(), exception.getMessage());
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    @DisplayName("실패 : 시도 횟수 0 입력")
    void 시도_횟수_입력_실패_0() {
        // 정상적인 음의 정수 입력 (예외 발생 예상)
        String negativeAttempt = "0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            AttemptValidation.validate(negativeAttempt);
        });
        assertEquals(RacingExceptionStatus.INVALID_ATTEMPTS_INTEGER.getMessage(), exception.getMessage());
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    @DisplayName("실패 : 시도 횟수 문자 입력")
    void 시도_횟수_입력_실패_문자() {
        String negativeAttempt = "three";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            AttemptValidation.validate(negativeAttempt);
        });
        assertEquals(RacingExceptionStatus.INVALID_ATTEMPTS_INTEGER.getMessage(), exception.getMessage());
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

}
