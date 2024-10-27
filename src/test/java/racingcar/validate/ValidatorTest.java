package racingcar.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Test
    void 올바른_입력_패턴_예외_테스트() {
        String input = "pobi,woni,도현,123,p0b1,도1현2";

        assertDoesNotThrow(() -> Validator.getValidatedCarNames(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,", ",woni", "!@,#$", "do현!", ",", "도,,현"})
    void 잘못된_입력_패턴_예외_테스트(String input) {
        assertThatThrownBy(() -> Validator.getValidatedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi123", ""})
    void 잘못된_이름_길이_예외_테스트(String input) {
        assertThatThrownBy(() -> Validator.getValidatedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_입력_예외_테스트() {
        String input = "도현,도현,pobi";

        assertThatThrownBy(() -> Validator.getValidatedCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "999"})
    void 올바른_반복값_입력_테스트(String input) {
        assertDoesNotThrow(() -> Validator.getValidatedRepeatCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1.5", "abc", "도현", "!", " "})
    void 잘못된_반복값_입력_테스트(String input) {
        assertThatThrownBy(() -> Validator.getValidatedRepeatCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
