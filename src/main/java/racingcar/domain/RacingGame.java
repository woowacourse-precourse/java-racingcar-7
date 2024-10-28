package racingcar.domain;

import java.util.List;
import racingcar.service.RandomNumManager;
import racingcar.validation.NameValidator;

public class RacingGame {
    private final Cars cars;
    private final int rounds;
    private final RandomNumManager randomNumManager;

    public RacingGame(Cars cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
        this.randomNumManager = new RandomNumManager();
    }

    public void createCars(List<String> nameList) {
        NameValidator.validateNames(nameList);
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void executeRound() {
        for (Car car : cars) {
            int randomNum = RandomNumManager.generateRandomNumber();
            if (RandomNumManager.isGreaterThanThree(randomNum)) {
                car.moveForward();
            }
        }
    }
}
