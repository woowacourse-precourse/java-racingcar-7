package racingcar.validate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RepetitionCountValidatorTest {

    @Test
    @DisplayName("유효성 검사 성공")
    void shouldPassWhenValidRepetitionCount() {
        // given
        String count = "31";

        // expected
        Assertions.assertDoesNotThrow(
            () -> RepetitionCountValidator.validateRepetitionCount(count)
        );
    }

    @Test
    @DisplayName("숫자가 음수인 경우 실패")
    void shouldFailWhenCountIsNegative() {
        // given
        String count = "-31";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> RepetitionCountValidator.validateRepetitionCount(count)
        );
    }

    @Test
    @DisplayName("공백으로 입력된 경우 실패")
    void shouldFailWhenCountIsBlank() {
        // given
        String count = "";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> RepetitionCountValidator.validateRepetitionCount(count)
        );
    }

    @Test
    @DisplayName("NULL로 입력된 경우 실패")
    void shouldFailWhenCountIsNull() {
        // given
        String count = null;

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> RepetitionCountValidator.validateRepetitionCount(count)
        );
    }

    @Test
    @DisplayName("입력이 숫자가 아닌 경우 실패")
    void shouldFailWhenCountIsNotANumber() {
        // given
        String count = "thirty one";

        // expected
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> RepetitionCountValidator.validateRepetitionCount(count)
        );
    }
}