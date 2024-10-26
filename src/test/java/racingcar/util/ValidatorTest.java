package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void NullExceptionTest() {
        // given
        String input = null;
        // when & then
        assertThatThrownBy(() ->  validator.checkCarNamesInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void EmptyExceptionTest() {
        // given
        String input = "";
        // when & then
        assertThatThrownBy(() ->  validator.checkCarNamesInput(input))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lengthExceptionTest() {
        // given
        String input = "abc543";
        // when & then
        assertThatThrownBy(() ->  validator.checkCarNamesInput(input))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPositiveCountExceptionTest() {
        // given
        String count = "-100";
        // when & then
        assertThatThrownBy(() ->  validator.checkLoopCount(count))
        .isInstanceOf(IllegalArgumentException.class);
    }

}