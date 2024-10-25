package racingcar.utills;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static racingcar.exception.Exception.INVALID_TRY_COUNT;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputDeviceTest {

    @Test
    void 숫자가_아닌_입력이라면_예외를_반환한다() {
        // given
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Throwable thrown = catchThrowable(() -> InputDevice.readInt());

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRY_COUNT.getMessage());
    }

    @Test
    void 빈_문자열이라면_예외를_반환한다() {
        // given
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Throwable thrown = catchThrowable(() -> InputDevice.readInt());

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRY_COUNT.getMessage());
    }
}