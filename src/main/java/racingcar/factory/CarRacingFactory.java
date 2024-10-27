package racingcar.factory;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.Player;
import racingcar.model.RacingGame;

public class CarRacingFactory implements GameFactory{
    public Player getPlayer(String name) {
        return new Car(name);
    }

    public Game getGame() {
        return new RacingGame();
    }
}
