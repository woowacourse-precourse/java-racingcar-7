package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {
    @Test
    void testCreate() {
        RacingGame racingGame = new RacingGame(List.of("a", "b", "c"), 5);
        assertEquals(3, racingGame.getState().size());
        assertEquals(0, racingGame.getState().get("a"));
        assertEquals(0, racingGame.getState().get("b"));
        assertEquals(0, racingGame.getState().get("c"));
    }
}
