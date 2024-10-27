package racingcar.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingValidatorTest {

    @Test
    void 시도_횟수_숫자() {
        assertThatThrownBy(() -> {
            RacingValidator.tryCountParseInteger("String");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효 하지 않은 시도할 횟수 입니다.");
    }

    @Test
    void 시도_횟수_공백() {
        assertThatThrownBy(() -> {
            RacingValidator.tryCountEmpty("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수를 입력해 주세요.");
    }
}