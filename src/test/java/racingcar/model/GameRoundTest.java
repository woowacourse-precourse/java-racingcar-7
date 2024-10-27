package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameRoundTest {
    @Test
    @DisplayName("숫자가 아닌 값이 입력되었을 때 예외가 발생해야 한다")
    void invalidNumber() {
        assertThatThrownBy(() -> new GameRound("five"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수 값이 입력되었을 때 예외가 발생해야 한다")
    void invalidPositiveNumber() {
        assertThatThrownBy(() -> new GameRound("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열이 입력되었을 때 예외가 발생해야 한다")
    void emptyInput() {
        assertThatThrownBy(() -> new GameRound(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백이 포함된 값이 입력되었을 때 예외가 발생해야 한다")
    void whitespaceInput() {
        assertThatThrownBy(() -> new GameRound("4 "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
