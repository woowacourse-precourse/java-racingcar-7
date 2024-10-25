package racingcar.racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGameConcreteFactory implements RacingGameFactory {
    private final int

    @Override
    public Game createGame(int allStage) {
        return new Game(allStage);
    }

    @Override
    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    @Override
    public Winner createWinner(Game game) {
        return new Winner(game);
    }
}
