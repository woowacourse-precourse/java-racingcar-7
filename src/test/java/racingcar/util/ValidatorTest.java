package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 이상인 경우 예외 발생")
    void validateCarNameTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> InputValidator.validate("pobi, woniii, jun", "1"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("이동 횟수가 1 미만인 경우 예외 발생")
    void validateMovesTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> InputValidator.validate("pobi, woni, jun", "0"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("정상적으로 입력값이 주어진 경우 예외 발생하지 않음")
    void validateTest() {
        assertSimpleTest(() -> {
            InputValidator.validate("pobi, woni, jun", "1");
        });
    }
}
