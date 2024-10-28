package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class RacingGameTest {
    //1. 자동차 이름 입력 및 유효성 검사 테스트
    @Test
    void shouldThrowExceptionForInvalidCarNameLength() {
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.validateCarName("longname"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void shouldAcceptValidCarNames() {
        RacingGame racingGame = new RacingGame();
        assertDoesNotThrow(() -> racingGame.validateCarName("pobi"));
    }
}
