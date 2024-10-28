package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 자동차_이름은_5자이하다() {
        assertThatThrownBy(() -> Validator.validateCarNames(List.of("이름이5글자넘는자동차")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_CAR_NAME);
    }

    @Test
    void 시도할_횟수는_숫자다() {

        assertThatThrownBy(() -> Validator.validateRound("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_NUMERIC_ROUND_COUNT);
    }

    @Test
    void 시도할_횟수는_0이상이다() {
        assertThatThrownBy(() -> Validator.validateRound("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ROUND_COUNT);
    }
}