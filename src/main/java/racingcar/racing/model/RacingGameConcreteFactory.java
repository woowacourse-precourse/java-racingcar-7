package racingcar.racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGameConcreteFactory implements RacingGameFactory {

    @Override
    public Game createGame(int allRound, List<Car> cars) {
        return new Game(allRound, cars);
    }

    @Override
    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
