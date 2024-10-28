package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.Validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    void 자동차이름이_null이면_예외를_반환한다() {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateCarNames(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 자동차이름이_비어있으면_예외를_반환한다(String input) {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateCarNames(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void 게임횟수가_0_이하면_예외를_반환한다(int input) {
        assertThrows(IllegalArgumentException.class, () ->
                Validator.validateGameCount(input));
    }
}