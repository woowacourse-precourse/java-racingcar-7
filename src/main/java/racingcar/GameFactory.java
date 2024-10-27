package racingcar;

import racingcar.car.Car;
import racingcar.decider.Decider;
import racingcar.decider.FixedRatioDecider;
import racingcar.observer.GameResultObserver;
import racingcar.observer.Observer;

import java.util.List;

public class GameFactory {
    public static CarGame of(List<String> names, int numberOfTurn) {
        Decider decider = new FixedRatioDecider(4, 9);
        List<Car> cars = names.stream().map(name -> CarFactory.of(name, decider)).toList();
        CarGame game = new CarGame(numberOfTurn, cars);
        Observer gameObserver = GameResultObserver.stdOut(cars);
        game.appendObserver(gameObserver);
        return game;
    }
}
