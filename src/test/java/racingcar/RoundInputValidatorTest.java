package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validators.RoundInputValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundInputValidatorTest {
    private final RoundInputValidator validator = new RoundInputValidator();

    @DisplayName("시도 횟수로 입력한 값이 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"asdf", "0", "-10", "1.23", "301"})
    void 횟수_입력값_검증_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(input));
    }
}
