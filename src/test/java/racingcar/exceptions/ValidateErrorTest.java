package racingcar.exceptions;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidateErrorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "-3"})
    void 시도_횟수_입력_예외_테스트(String tryNumber) {
        assertThatThrownBy(() -> ValidateError.validateTryNumber(tryNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "asdfghjk"})
    void 자동차_이름_입력_예외_테스트(String carName) {
        assertThatThrownBy(() -> ValidateError.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
