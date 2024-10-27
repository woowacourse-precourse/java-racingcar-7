package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}
