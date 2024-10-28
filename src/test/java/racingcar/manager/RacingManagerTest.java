package racingcar.manager;

import org.junit.jupiter.api.Test;
import racingcar.config.AppConfig;

import static org.junit.jupiter.api.Assertions.*;

class RacingManagerTest {

    @Test
    void racingManagerTest() {
        RacingManager racingManager = new RacingManager();
        racingManager.registerCars("CarA,CarB,CarC");

        racingManager.race("3");

        racingManager.presentWinner();
    }
}