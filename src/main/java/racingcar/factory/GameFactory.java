package racingcar.factory;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.car.Car;
import racingcar.strategy.MoveStrategy;

public class GameFactory {

    private final MoveStrategy moveStrategy;

    public GameFactory(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Game createGame(List<String> carNames, int totalRounds) {
        List<Car> cars = createCarsFromNames(carNames);
        return new Game(cars, totalRounds);
    }

    private List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, moveStrategy))
                .toList();
    }
}
