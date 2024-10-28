package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    @DisplayName("자동차의_이름이_중복되면_예외를_발생한다")
    public void should_ThrowException_When_CarNameDuplicated() {
        //given
        RacingGame racingGame = new RacingGame();
        List<String> carNames = List.of("abc", "abc", "d");

        //when
        //then
        assertThatThrownBy(() -> racingGame.run(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복될 수 없습니다");
    }
    
    @Test
    @DisplayName("자동차가_0대이면_예외를_발생한다")
    public void should_ThrowException_When_NoCar() {
        //given
        RacingGame racingGame = new RacingGame();
        List<String> carNames = List.of();

        //when
        //then
        assertThatThrownBy(() -> racingGame.run(carNames, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 최소 1대 이상이어야 합니다");
    }
}