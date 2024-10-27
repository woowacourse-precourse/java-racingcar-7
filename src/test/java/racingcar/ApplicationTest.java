package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {

    @Test
    void 입력_자동차_이름_검증() {
        assertThatThrownBy(() -> Application.inputCarNames())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
