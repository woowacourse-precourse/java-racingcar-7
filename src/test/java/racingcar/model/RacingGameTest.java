package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.utils.TestNumberGenerator;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class RacingGameTest {

    @Test
    void 현재_자동차_위치_조회_테스트() {
        RaceCars raceCars = RaceCars.fromNames(List.of("car1", "car2", "car3"));
        AttemptCount attemptCount = AttemptCount.from(3);
        RacingGame racingGame = new RacingGame(raceCars, attemptCount, new TestNumberGenerator(9));

        Map<String, Integer> currentPosition = racingGame.findCurrentPosition();
        assertEquals(Map.of("car1", 0, "car2", 0, "car3", 0), currentPosition);
    }
}
