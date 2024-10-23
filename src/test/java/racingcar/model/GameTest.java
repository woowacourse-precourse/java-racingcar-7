package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;
    private int attemptCount;

    @BeforeEach
    void setUp() {
        attemptCount = 3;
        game = new Game(new String[]{"pobi", "woni", "jun"}, attemptCount);
    }

    @Test
    @DisplayName("시도 횟수만큼 반복한 뒤에는 isRunning 이 false 를 반환한다.")
    void shouldReturnFalseAfterAttemptCountRepetitions() {
        // when
        for (int i = 0; i < attemptCount; i++) {
            game.play();
        }

        // then
        assertThat(game.isRunning()).isFalse();
    }

    @Test
    @DisplayName("시도 횟수만큼 반복하기 이전에는 isRunning 이 true 를 반환한다.")
    void shouldReturnTrueBeforeAttemptCountRepetitions() {
        // when
        for (int i = 0; i < attemptCount - 1; i++) {
            game.play();
        }

        // then
        assertThat(game.isRunning()).isTrue();
    }
}
