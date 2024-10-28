package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.Validator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    void 자동차이름_null_예외테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateCarNames(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 자동차이름_빈값일_떼_예외테스트(String input) {
        List<String> carNames = List.of(input);
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateCarNames(carNames));
    }
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void 게임횟수_0_혹은_음수_예외테스트(int input) {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateAttemptCount(String.valueOf(input)));
        }
}
