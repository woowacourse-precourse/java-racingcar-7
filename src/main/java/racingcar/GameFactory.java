package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.decider.Decider;
import racingcar.decider.FixedRatioDecider;
import racingcar.observer.Observer;

public class GameFactory {
    public static CarGame of(List<String> names, int numberOfTurn) {
        Decider decider = new FixedRatioDecider(4, 9);
        List<Car> cars = names.stream().map(name -> CarFactory.of(name, decider)).toList();
        CarGame game = new CarGame(numberOfTurn, cars);
        Observer gameObserver = OutputObserverFactory.getInstance()
                .stdOutGameResultObserver(cars);
        Observer exeObserver = OutputObserverFactory.getInstance()
                .stdOutExecutionObserver(cars);

        game.subscribeExecuteObserver(exeObserver);
        game.subscribeResultObserver(gameObserver);
        return game;
    }
}
