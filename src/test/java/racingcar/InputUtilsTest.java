package racingcar;

import static racingcar.Constant.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputUtilsTest {
    @Test
    void 자동차_이름이_5자_초과() {
        System.setIn(new ByteArrayInputStream("Audi,BMW,Ford,Ferrari".getBytes()));

        assertThatThrownBy(InputUtils::inputCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_INPUT_ERROR_MESSAGE);
    }

    @Test
    void 시도_횟수_입력이_정수가_아닐_때() {
        System.setIn(new ByteArrayInputStream("-1".getBytes()));

        assertThatThrownBy(InputUtils::inputAttempt)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPT_INPUT_ERROR_MESSAGE);
    }
}
