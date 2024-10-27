package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ErrorMessage;

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

    @ParameterizedTest
    @DisplayName("양수가 아닌 수를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0"})
    void createRoundCountWithNegativeOrZero(String input) {
        // when, then
        Assertions.assertThatThrownBy(() -> new RoundCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ROUND_COUNT_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("roundcount가 0이하라면 감소시킬 때 예외가 발생한다.")
    void decreaseRoundCount() {
        // given
        RoundCount round = new RoundCount("1");
        round.decrease();
        // when, then
        Assertions.assertThatThrownBy(round::decrease)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.NO_MORE_ROUND.getMessage());
    }

    @Test
    @DisplayName("남은 라운드가 없으면 true를 반환한다.")
    void hasNoRemainingRound() {
        // given
        RoundCount round = new RoundCount("1");
        round.decrease();
        // when, then
        Assertions.assertThat(round.hasRemainingRound()).isFalse();
    }
}