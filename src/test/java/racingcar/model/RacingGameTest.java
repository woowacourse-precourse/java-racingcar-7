package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class RacingGameTest {

    @Test
    void 현재_자동차_위치_조회_테스트() {
        RaceCars raceCars = new RaceCars(List.of("raceCar1", "raceCar2", "raceCar3"));
        AttemptCount attemptCount = new AttemptCount(3);
        RacingGame racingGame = new RacingGame(raceCars, attemptCount);

        Map<String, Integer> currentPosition = racingGame.findCurrentPosition();
        Assertions.assertEquals(Map.of("raceCar1", 0, "raceCar2", 0, "raceCar3", 0), currentPosition);
    }
}
