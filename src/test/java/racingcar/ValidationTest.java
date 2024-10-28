package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void 자동차_이름_검증_정상_케이스() {
        String[] carNames = {"pobi", "woni", "java"};
        assertDoesNotThrow(() -> Validation.validateCarNames(carNames));
    }

    @Test
    void 자동차_이름_빈문자열_예외() {
        String[] carNames = {"", "pobi", "java"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(carNames));
        assertEquals("자동차 이름은 빈 문자열일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_null_예외() {
        String[] carNames = {null, "pobi", "java"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(carNames));
        assertEquals("자동차 이름은 빈 문자열일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 자동차_이름_길이_초과_예외() {
        String[] carNames = {"pobi", "woni", "racingcar"};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateCarNames(carNames));
        assertEquals("자동차 이름은 1자 이상 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    void 시도_횟수_검증_정상_케이스() {
        assertDoesNotThrow(() -> Validation.validateAttemptCount("3"));
    }

    @Test
    void 시도_횟수_빈문자열_예외() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateAttemptCount(""));
        assertEquals("시도 횟수를 입력해 주세요.", exception.getMessage());
    }

    @Test
    void 시도_횟수_null_예외() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateAttemptCount(null));
        assertEquals("시도 횟수를 입력해 주세요.", exception.getMessage());
    }

    @Test
    void 시도_횟수_음수_예외() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateAttemptCount("-1"));
        assertEquals("시도 횟수는 양수여야 합니다.", exception.getMessage());
    }

    @Test
    void 시도_횟수_문자열_예외() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateAttemptCount("abc"));
        assertEquals("시도 횟수는 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    void 구분자_검증_정상_케이스() {
        String input = "pobi,woni,java";
        assertDoesNotThrow(() -> Validation.validateDelimiter(input));
    }

    @Test
    void 구분자_없는_경우_예외() {
        String input = "pobi woni java";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateDelimiter(input));
        assertEquals("입력 값에 쉼표(,)가 포함되어야 합니다.", exception.getMessage());
    }
}
