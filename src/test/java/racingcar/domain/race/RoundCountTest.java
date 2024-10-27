package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;

class RoundCountTest {

    @Test
    @DisplayName("시도할 횟수 - 빈 문자열 입력")
    void blankInput() {
        //given
        final String input = "";

        //when & then
        assertThatThrownBy(() -> RoundCount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_ROUND_COUNT_INPUT.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수 - 숫자가 아닌 문자 입력")
    void invalidInput() {
        //given
        final String input = "a";

        //when & then
        assertThatThrownBy(() -> RoundCount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
    }

    @Test
    @DisplayName("시도할 횟수 - 음수 입력")
    void NegativeNumberInput() {
        //given
        final String input = "-1";

        //when & then
        assertThatThrownBy(() -> RoundCount.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
    }
}