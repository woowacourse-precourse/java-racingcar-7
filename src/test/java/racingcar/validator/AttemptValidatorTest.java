package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("AttemptValidator 검증 테스트")
class AttemptValidatorTest {

    private final AttemptValidator attemptValidator = new AttemptValidator();

    @DisplayName("0이 입력되면 예외를 발생시킨다.")
    @Test
    void fail1() {
        String input = "0";
        assertThrows(IllegalArgumentException.class, () -> attemptValidator.validate(input));
    }

    @DisplayName("음의 정수가 입력되면 예외를 발생시킨다.")
    @Test
    void fail2() {
        String input = "-3";
        assertThrows(IllegalArgumentException.class, () -> attemptValidator.validate(input));
    }

    @DisplayName("정수가 아닌 실수가 입력되면 예외를 발생시킨다.")
    @Test
    void fail3() {
        String input = "4.5";
        assertThrows(IllegalArgumentException.class, () -> attemptValidator.validate(input));
    }

}