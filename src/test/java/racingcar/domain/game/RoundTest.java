package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    Round round;

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "100"})
    public void 유효한_라운드_횟수를_입력하면_예외가_발생하지_않는다(String userInput) {
        //given
        Round round = new Round(userInput);

        //when
        int getRound = round.getRound();

        //when then
        assertThat(getRound).isEqualTo(Integer.parseInt(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "123a", "a123 ", "a123a", " 123", "123 ", " 123 "})
    public void 라운드_횟수에_숫자가_아닌_문자열이_포함되면_예외가_발생한다(String userInput) {
        Assertions.assertThatThrownBy(() -> new Round(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "101"})
    public void 라운드_횟수가_지정한_범위를_벗어나면_예외가_발생한다(String userInput) {
        Assertions.assertThatThrownBy(() -> new Round(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}