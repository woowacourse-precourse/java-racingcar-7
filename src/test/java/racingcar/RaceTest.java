package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Race;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {
    @Test
    @DisplayName("일정한_턴을_가진_게임이_생성된다")
    public void 일정한_턴을_가진_게임이_생성된다() {
        int turnCount = 5;

        Race race = new Race(5);
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 6, 100})
    @DisplayName("턴이_0이하_또는_6이상의_입력으로_예외가_발생한다")
    public void 턴이_0이하_또는_6이상의_입력으로_예외가_발생한다(int turn) {
        assertThrows(IllegalArgumentException.class, () -> new Race(turn));
    }
}
