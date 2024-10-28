package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.race.exception.AttemptCountException;
import racingcar.race.validation.AttemptCountValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AttemptCountValidatorTest {

    AttemptCountValidator validator = new AttemptCountValidator();

    @Test
    void 시도_횟수가_빈값이면_예외() {
        AttemptCountException exception = assertThrows(AttemptCountException.class,
                () -> validator.validateAttemptCount(""));
        assertEquals("시도 횟수는 빈 입력일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 시도_횟수가_null이면_예외() {
        AttemptCountException exception = assertThrows(AttemptCountException.class,
                () -> validator.validateAttemptCount(null));
        assertEquals("시도 횟수는 null일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 시도_횟수가_정수가_아니면_예외() {
        AttemptCountException exception = assertThrows(AttemptCountException.class,
                () -> validator.validateAttemptCount("abc"));
        assertEquals("시도 횟수는 정수여야 합니다.", exception.getMessage());
    }

    @Test
    void 시도_횟수가_음수이면_예외() {
        AttemptCountException exception = assertThrows(AttemptCountException.class,
                () -> validator.validateAttemptCount("-1"));
        assertEquals("시도 횟수는 음수일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 시도_횟수가_0이면_예외() {
        AttemptCountException exception = assertThrows(AttemptCountException.class,
                () -> validator.validateAttemptCount("0"));
        assertEquals("시도 횟수는 0일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 유효한_시도_횟수() {
        validator.validateAttemptCount("3");  // 예외가 발생하지 않아야 함
    }
}
