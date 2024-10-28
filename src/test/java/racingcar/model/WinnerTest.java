package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;

class WinnerTest {

    private Winner winner;
    private HashMap<String, Integer> raceStatus;

    @BeforeEach
    void setUp() {
        winner = new Winner();
        raceStatus = new HashMap<>();
        raceStatus.put("pobi", 3);
        raceStatus.put("crong", 5);
        raceStatus.put("honux", 5);
    }

    @Test
    void informWho_우승자_판별_테스트() {
        List<String> winners = winner.informWho(raceStatus);

        // 우승자는 crong과 honux이어야 함
        assertEquals(2, winners.size());
        assertTrue(winners.contains("crong"));
        assertTrue(winners.contains("honux"));
    }
}
