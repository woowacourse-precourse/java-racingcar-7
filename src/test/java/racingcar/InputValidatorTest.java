package racingcar;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"hello", "hi", "name"})
    void 차의_이름이_5글자를_넘지_않는_경우_예외가_발생하지_않는다(String name) {
        assertThatNoException().isThrownBy(() -> InputValidator.validateCarName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"frankburger", "fiveguys", "burgerking"})
    void 차의_이름이_5글자를_넘는_경우_예외가_발생한다(String name) {
        assertThatThrownBy(() -> InputValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름은 5글자 이하여야 합니다.");
    }

}