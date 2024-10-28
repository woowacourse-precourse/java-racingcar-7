package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumber;

public class CarRacingGame {

    private static final List<Car> racingCars = new ArrayList<>();

    private final RandomNumber randomNumber;

    public CarRacingGame(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static CarRacingGame create(List<String> carNames, RandomNumber randomNumber) {
        for (String carName : carNames) {
            racingCars.add(Car.create(carName));
        }
        return new CarRacingGame(randomNumber);
    }

    public void moveCars() {
        int racingCarsCount = racingCars.size();
        List<Integer> randomNumbers = randomNumber.createNumbers(racingCarsCount);

        for (int i = 0; i < racingCarsCount; i++) {
            moveCar(racingCars.get(i), randomNumbers.get(i));
        }
    }

    private void moveCar(Car car, Integer number) {
        if (number >= 4) {
            car.move();
        }
    }
}
