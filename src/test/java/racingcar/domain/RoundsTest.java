package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundsTest {

    @DisplayName("시도할 횟수 입력 실패 : 문자 입력")
    @Test
    void toIntTest() {
        String rawCount = "a";

        Assertions.assertThatThrownBy(() -> new Rounds(rawCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수로 숫자를 입력해주세요.");
    }
}
