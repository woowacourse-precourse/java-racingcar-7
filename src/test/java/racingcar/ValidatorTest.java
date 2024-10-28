package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외를 던진다")
    void validateCarNameLength() {
        String[] carNames = {"pobi", "woniwon"};
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백을 포함할 경우 예외를 던진다")
    void validateCarNameWithSpaces() {
        String[] carNames = {"po bi", "woni"};
        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에는 공백이 포함될 수 없습니다.");
    }
}
