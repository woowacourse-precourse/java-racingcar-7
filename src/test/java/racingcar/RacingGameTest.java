package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("자동차의_이름이_중복되면_예외를_발생한다")
    public void should_ThrowException_When_CarNameDuplicated() {
        //given
        RacingGame racingGame = new RacingGame();

        //when
        //then
        assertThatThrownBy(() -> racingGame.run("abc,abc,d", 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복될 수 없습니다");
    }
}