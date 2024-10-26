package racingcar.common;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameValidatorTest {

    @Test
    @DisplayName("빈 선수 이름은 예외를 던진다")
    void assertBlankNameWillThrowException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> NameValidator.isNotBlank(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("name cannot be blank")
        );
    }

    @Test
    void isValidSize() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> NameValidator.isValidSize("aaaaaa"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("size of member's name is over 5")
        );
    }
}
