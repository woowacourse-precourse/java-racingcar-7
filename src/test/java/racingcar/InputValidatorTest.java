package racingcar;

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

    @ParameterizedTest
    @NullSource
    void 차의_이름이_널_값인_경우_예외가_발생한다(String name) {
        assertThatThrownBy(() -> InputValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름이 null 이면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " ello"})
    void 차의_이름이_공백을_포함하는_경우_예외가_발생한다(String name) {
        assertThatThrownBy(() -> InputValidator.validateCarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차의 이름에 공백을 포함하면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-11, -1, -1234, 0})
    void validateNumeric(int num) {
        assertThatThrownBy(() -> InputValidator.validateNumeric(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 최소 한 번 입니다.");
    }

}