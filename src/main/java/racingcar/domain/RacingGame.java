package racingcar.domain;

import racingcar.util.RandomGenerator;
import racingcar.util.RandomGeneratorImpl;

import java.util.List;

public class RacingGame {
    private List<Car> carList;
    private final RandomGenerator randomGenerator;
    private final RacingRule racingRule;

    public RacingGame() {
        this.randomGenerator = new RandomGeneratorImpl();
        this.racingRule = new RacingRule();
    }

    public void setCars(List<Car> carList) {

        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void play() {
        for (Car car : carList) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        int randomNumber = randomGenerator.generateRandomNumber();
        car.move(randomNumber, racingRule);
    }

}
