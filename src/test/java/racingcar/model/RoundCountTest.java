package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ErrorMessage;

class RoundCountTest {
    @Test
    @DisplayName("RoundCount 객체를 생성할 수 있다.")
    void createRoundCount() {
        // given
        String roundCount = "5";
        // when
        RoundCount round = new RoundCount(roundCount);
        // then
        Assertions.assertThat(round).isNotNull();
    }

    @Test
    @DisplayName("숫자가 아닌 문자열을 입력하면 예외가 발생한다.")
    void createRoundCountWithInvalidInput() {
        // given
        String invalidInput = "우테코";
        // when, then
        Assertions.assertThatThrownBy(() -> new RoundCount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
    }
}