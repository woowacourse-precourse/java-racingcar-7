package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import racingcar.validator.InputValidator;

public class InputValidatorTest {
	@Test
    void 올바른_자동차_이름_검증() {
        String[] names = {"car1", "car2", "car3"};
        assertThatCode(() -> InputValidator.validateCarNames(names))
                .doesNotThrowAnyException();
    }

    @Test
    void 잘못된_자동차_이름_검증() {
        String[] names = {"car1", "toolongname", "car3"};
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 올바른_시도_횟수_검증() {
        assertThatCode(() -> InputValidator.validateTrilaNum("3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 잘못된_시도_횟수_검증() {
        assertThatThrownBy(() -> InputValidator.validateTrilaNum("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
