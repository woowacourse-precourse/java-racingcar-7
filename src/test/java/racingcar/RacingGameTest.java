package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


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

    // 2. 시도 횟수 입력 및 유효성 검사 테스트
    @Test
    void shouldThrowExceptionForNonNumericAttempts() {
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.validateAttempts("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 자연수여야 합니다.");
    }

    @Test
    void shouldThrowExceptionForZeroOrNegativeAttempts() {
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.validateAttempts("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0보다 큰 자연수여야 합니다.");
    }

    @Test
    void shouldAcceptValidAttempts() {
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.validateAttempts("5"))
                .doesNotThrowAnyException();
    }
}
