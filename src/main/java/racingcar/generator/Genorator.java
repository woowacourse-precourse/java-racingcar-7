package racingcar.generator;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.Player;
import racingcar.model.RacingGame;

public class Genorator {
    static Player getPlayer(String name) {
        return new Car(name);
    }

    static Game getGamer() {
        return new RacingGame();
    }
}
