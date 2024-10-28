package racingcar.controller;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameFlowTest {

    @Test
    void should_SetNumberOfMoves_When_InputIsValid() {
        GameFlow gameFlow = new GameFlow();
        String validInput = "5";
        gameFlow.setNumberOfMoves(validInput);
        assertThat(gameFlow.getNumberOfMoves()).isEqualTo(5);
    }

    @Test
    void should_ThrowException_When_InputIsZero() {
        GameFlow gameFlow = new GameFlow();
        String zeroInput = "0";
        assertThatThrownBy(() -> gameFlow.setNumberOfMoves(zeroInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 1 이상의 양수여야 합니다.");
    }

    @Test
    void should_ThrowException_When_InputIsNegative() {
        GameFlow gameFlow = new GameFlow();
        String negativeInput = "-3";
        assertThatThrownBy(() -> gameFlow.setNumberOfMoves(negativeInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 1 이상의 양수여야 합니다.");
    }

    @Test
    void should_ThrowException_When_InputIsNotANumber() {
        GameFlow gameFlow = new GameFlow();
        String invalidInput = "abc";
        assertThatThrownBy(() -> gameFlow.setNumberOfMoves(invalidInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 아라비아 숫자여야 합니다.");
    }

    @Test
    void should_ThrowException_When_InputIsEmpty() {
        GameFlow gameFlow = new GameFlow();
        String emptyInput = "";
        assertThatThrownBy(() -> gameFlow.setNumberOfMoves(emptyInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 아라비아 숫자여야 합니다.");
    }

    @Test
    void should_ThrowException_When_InputIsNull() {
        GameFlow gameFlow = new GameFlow();
        String nullInput = null;
        assertThatThrownBy(() -> gameFlow.setNumberOfMoves(nullInput)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동 횟수는 아라비아 숫자여야 합니다.");
    }
}
