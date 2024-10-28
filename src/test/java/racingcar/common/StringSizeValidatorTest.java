package racingcar.common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSizeValidatorTest {

    @Test
    @DisplayName("빈 선수 이름은 예외를 던진다")
    void assertBlankNameWillThrowException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> StringSizeValidator.checkBlank(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("name cannot be blank")
        );
    }

    @Test
    void checkLimitedSize() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> StringSizeValidator.checkLimitedSize("aaaaaa", 5))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("length of string's is over")
        );
    }
}
