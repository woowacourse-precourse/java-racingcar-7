package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

class GameTest {

    private Game game;
    private HashMap<String, Integer> raceStatus;

    @BeforeEach
    void setUp() {
        game = new Game();
        raceStatus = new HashMap<>();
        raceStatus.put("pobi", 0);
        raceStatus.put("crong", 0);
    }

    @Test
    void play_자동차_위치_업데이트_테스트() {
        raceStatus = game.play(raceStatus);

        // 자동차 위치는 초기 상태(0)에서 증가할 수 있음
        assertTrue(raceStatus.get("pobi") >= 0);
        assertTrue(raceStatus.get("crong") >= 0);
    }
}
