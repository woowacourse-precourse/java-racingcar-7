package racingcar.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void 자동차_이름을_공백으로_입력받는_경우_예외테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNamesInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 레이싱_시도_횟수를_공백으로_입력받는_경우_예외테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNamesInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_마지막에_콤마가_있는_경우_예외테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNamesInput("raceCar1, raceCar2,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름에_특수문자가_있는_경우_예외테스트() {
        assertThatThrownBy(() -> InputValidator.validateCarNamesInput("raceCar1* raceCar2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "한글", "*"})
    void 시도횟수가_숫자가_아닌_경우_예외테스트(String value) {
        assertThatThrownBy(() -> InputValidator.validateAttemptCountInput(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "00"})
    void 시도횟수가_0_으로_시작할_경우_예외테스트(String value) {
        assertThatThrownBy(() -> InputValidator.validateAttemptCountInput(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
