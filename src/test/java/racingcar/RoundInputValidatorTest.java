package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validators.RoundInputValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundInputValidatorTest {
    private final RoundInputValidator validator = new RoundInputValidator();

    @DisplayName("시도 횟수로 입력한 값이 유효하지 않으면 예외를 발생시킨다.")
    @Test
    void 횟수_입력값_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("asdf"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("0"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("-10"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1.23"));
        assertThrows(IllegalArgumentException.class, () -> validator.validate("301"));
    }
}
